package com.vms.offer.mapper;

import com.vms.offer.dto.OfferDTO;
import com.vms.offer.entity.Offer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FunctionalInterface
@Mapper(componentModel = "spring")
public interface OfferMapper {
    OfferDTO convertOfferToOfferDTO(Offer offer);
}
