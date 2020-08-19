package com.vms.offeredservice.mapper;

import com.vms.offeredservice.dto.ServiceDTO;
import com.vms.offeredservice.entity.OfferDetails;
import com.vms.offeredservice.entity.ServiceDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring")
public interface OfferedServiceMapper {

    List<ServiceDTO> converServicesToServiceDTOs(List<ServiceDetails> serviceDetail);

    @Mapping(target = "offerIds", expression = "java(getOfferIds(serviceDetails))")
    @Mapping(target = "offers", ignore = true)
    ServiceDTO converServiceToServiceDTO(ServiceDetails serviceDetails);

    public default List<Integer> getOfferIds(ServiceDetails serviceDetails) {
        return Optional.ofNullable(serviceDetails).map(ServiceDetails::getOfferDetail).orElseGet(Collections::emptySet)
                .stream().map(OfferDetails::getOfferdetailsId).collect(Collectors.toList());
    }
}
