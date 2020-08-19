package com.vms.offer.controller;

import com.vms.offer.dto.OfferDTO;
import com.vms.offer.entity.Offer;
import com.vms.offer.service.OfferService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }

    @GetMapping("/offers")
    public ResponseEntity<List<OfferDTO>> fetchAllOffers() {
        log.info(" fetchAllOffers ");
        return new ResponseEntity<>(offerService.fetchAllOffers(), HttpStatus.OK);
    }

    @PostMapping("/createoffer")
    public ResponseEntity<Offer> createoffer(@RequestBody Offer offer) {
        return new ResponseEntity<>(offerService.createOffer(offer), HttpStatus.OK);
    }

    @PostMapping("/offerdetails")
    public ResponseEntity<List<OfferDTO>> offerdetails(List<Integer> offerIds) {
        return new ResponseEntity<>(offerService.offerdetails(offerIds), HttpStatus.OK);
    }

    @GetMapping("/offers/{offerId}")
    public ResponseEntity<OfferDTO> fetchOfferById(@PathVariable Integer offerId) {
        log.info(" fetchOfferById for offerId {}", offerId);
        return new ResponseEntity<>(offerService.fetchOfferById(offerId), HttpStatus.OK);
    }
}
