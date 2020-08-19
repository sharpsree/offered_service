package com.vms.offeredservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vms.offer.dto.OfferDTO;
import com.vms.offeredservice.dto.ServiceDTO;
import com.vms.offeredservice.entity.ServiceDetails;
import com.vms.offeredservice.mapper.OfferedServiceMapper;
import com.vms.offeredservice.properties.OfferProperties;
import com.vms.offeredservice.repository.ServiceDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class OfferedServicesService {
    private final RestTemplate restTemplate;
    private final OfferedServiceMapper offeredServiceMapper;
    private final OfferProperties offerProperties;
    private final ServiceDetailsRepository serviceDetailsRepository;

    public List<ServiceDTO> findServiceHistory(Integer vinNumber){
        List<ServiceDetails> offeredServices = serviceDetailsRepository.findByVinNumber(vinNumber);
        List<ServiceDTO> serviceDTOs = offeredServiceMapper.converServicesToServiceDTOs(offeredServices);
        Optional.ofNullable(serviceDTOs).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull)
                .filter(service->service.getOfferIds() != null)
                .forEach(service->{
                    service.setOffers(findOfferDTOs(service.getOfferIds()));
                });
        return serviceDTOs;
    }

    public List<OfferDTO> findOfferDTOs(List<Integer> offerIds) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Integer>> entity = new HttpEntity<List<Integer>>(offerIds);
        String url = offerProperties.getOfferBaseUrl()+"/offerdetails";
        return restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<List<OfferDTO>>() {
        }).getBody();
    }


    @HystrixCommand(fallbackMethod = "findAllOfferDTOsDefault")
    public List<OfferDTO> findAllOfferDTOs() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Map<String, String> parameters = new HashMap<>();
        String url = offerProperties.getOfferBaseUrl()+"/offers";
        return restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<OfferDTO>>() {
        }, parameters).getBody();
    }

    public List<OfferDTO> findAllOfferDTOsDefault(Throwable exception) {
        log.error(" offer service is not available. Try after some time");
        return Collections.EMPTY_LIST;
    }


    public ServiceDetails getServiceDetails(Integer serviceId){
        return serviceDetailsRepository.getOne(serviceId);
    }
    public ServiceDetails saveServiceDetails(ServiceDetails service){
        return serviceDetailsRepository.save(service);
    }
}
