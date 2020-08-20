package com.vms.offeredservice.service;

import com.vms.offeredservice.dto.ServiceDTO;
import com.vms.offeredservice.entity.ServiceDetails;
import com.vms.offeredservice.mapper.OfferedServiceMapper;
import com.vms.offeredservice.repository.ServiceDetailsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class OfferedServicesServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OfferedServicesService offeredServicesService;

    @Mock
    private OfferedServiceMapper offeredServiceMapper;

    @Mock
    private ServiceDetailsRepository serviceDetailsRepository;

    @Test
    public void findServiceHistoryTest() {
        List<ServiceDetails> offeredServices = new ArrayList<>();
        ServiceDetails serviceDetail = new ServiceDetails();
        serviceDetail.setServicedetailsId(1);
        serviceDetail.setVinNumber(1);
        when(serviceDetailsRepository.findByVinNumber(1)).thenReturn(offeredServices);
        List<ServiceDTO> serviceDTOs = new ArrayList<>();
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTOs.add(serviceDTO);
        when(offeredServiceMapper.converServicesToServiceDTOs(any())).thenReturn(serviceDTOs);
       List<ServiceDTO> response = offeredServicesService.findServiceHistory(1);
       verify(serviceDetailsRepository, times(1)).findByVinNumber(1);
       assertFalse(response.isEmpty());
    }

    @Test
    public void getServiceDetailsTest() {
        ServiceDetails serviceDetail = new ServiceDetails();
        serviceDetail.setServicedetailsId(1);
        serviceDetail.setVinNumber(1);
        when(serviceDetailsRepository.getOne(1)).thenReturn(serviceDetail);
        ServiceDetails response = offeredServicesService.getServiceDetails(1);
        verify(serviceDetailsRepository, times(1)).getOne(1);
        assertNotNull(response);
    }

    @Test
    public void saveServiceDetailsTest() {
        ServiceDetails serviceDetail = new ServiceDetails();
        serviceDetail.setServicedetailsId(2);
        serviceDetail.setVinNumber(4);
        when(serviceDetailsRepository.save(serviceDetail)).thenReturn(serviceDetail);
        ServiceDetails response = offeredServicesService.saveServiceDetails(serviceDetail);
        verify(serviceDetailsRepository, times(1)).save(serviceDetail);
        assertNotNull(response);
    }

}
