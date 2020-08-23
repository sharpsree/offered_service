package com.vms.offeredservice.controller;

import com.vms.offer.dto.OfferDTO;
import com.vms.offeredservice.dto.ServiceDTO;
import com.vms.offeredservice.entity.ServiceDetails;
import com.vms.offeredservice.service.OfferedServicesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class OfferedServicesController {

    private final OfferedServicesService offeredServicesService;

    public OfferedServicesController(OfferedServicesService offeredServicesService){
        this.offeredServicesService = offeredServicesService;
    }

    @GetMapping("/findservicehistory")
    public ResponseEntity<List<ServiceDTO>> findServiceHistory(@RequestParam Integer vinNumber,
             @RequestParam(required = false) String version) {
        log.info(" Book Service");
        return new ResponseEntity<>(offeredServicesService.findServiceHistory(vinNumber, version), HttpStatus.OK);
    }

    @GetMapping("/findoffer")
    public ResponseEntity<List<OfferDTO>> findOfferDTO() {
        log.info(" Book Service");
        return new ResponseEntity<>(offeredServicesService.findAllOfferDTOs(), HttpStatus.OK);
    }

    @GetMapping("/servicedetails/{serviceId}")
    public ResponseEntity<ServiceDetails> getServiceDetails(@PathVariable Integer serviceId) {
        log.info(" Book Service");
        return new ResponseEntity<>(offeredServicesService.getServiceDetails(serviceId), HttpStatus.OK);
    }

    @PostMapping("/bookservice")
    public ResponseEntity<ServiceDetails> bookService(@RequestBody ServiceDetails serviceDetails) {
        log.info(" Book Service");
        return new ResponseEntity<>(offeredServicesService.saveServiceDetails(serviceDetails), HttpStatus.CREATED);
    }

    @PutMapping("/applyoffer")
    public ResponseEntity<ServiceDetails> applyOffer(@RequestBody ServiceDetails serviceDetails) {
        log.info(" Book Service");
        return new ResponseEntity<>(offeredServicesService.saveServiceDetails(serviceDetails), HttpStatus.ACCEPTED);
    }
}
