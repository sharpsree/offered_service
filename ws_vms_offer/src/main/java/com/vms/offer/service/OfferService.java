package com.vms.offer.service;

import com.vms.offer.dto.OfferDTO;
import com.vms.offer.entity.OfferDetails;
import com.vms.offer.mapper.OfferMapper;
import com.vms.offer.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper){
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    public List<OfferDTO> fetchAllOffers(){
        List<OfferDetails> offers = offerRepository.findAll();
        return Optional.ofNullable(offers).orElseGet(Collections::emptyList).parallelStream()
                .filter(Objects::nonNull).map(offerMapper::convertOfferToOfferDTO)
                .collect(Collectors.toList());
    }

    public List<OfferDTO> offerdetails(List<Integer> offerIds){
        List<OfferDetails> offers = offerIds.stream().map(offerRepository::getOne).collect(Collectors.toList());
        return Optional.ofNullable(offers).orElseGet(Collections::emptyList).parallelStream()
                .filter(Objects::nonNull).map(offerMapper::convertOfferToOfferDTO)
                .collect(Collectors.toList());
    }

    public OfferDetails createOffer(OfferDetails offer){
        return offerRepository.save(offer);
    }

    public OfferDTO fetchOfferById(Integer offerId){
        OfferDTO offerDTO = null;
        OfferDetails offer = offerRepository.getOne(offerId);
        if(offer != null){
            offerDTO = offerMapper.convertOfferToOfferDTO(offer);
        }
        return offerDTO;
    }
}
