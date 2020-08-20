package com.vms.offeredservice.controller;

import com.vms.offer.dto.OfferDTO;
import com.vms.offeredservice.dto.ServiceDTO;
import com.vms.offeredservice.entity.ServiceDetails;
import com.vms.offeredservice.service.OfferedServicesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class OfferedServicesControllerTest {

    @InjectMocks
    private OfferedServicesController offeredServicesController;

    @Mock
    private OfferedServicesService offeredServicesService;

    @Test
    public void findServiceHistoryTest() {
        List<ServiceDTO> serviceDTOs = new ArrayList<>();
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTOs.add(serviceDTO);
        when(offeredServicesService.findServiceHistory(any())).thenReturn(serviceDTOs);
        ResponseEntity<List<ServiceDTO>> response = offeredServicesController.findServiceHistory(1);
        verify(offeredServicesService, times(1)).findServiceHistory(any());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void findOfferDTOTest() {
        List<OfferDTO> offerDTOs = new ArrayList<>();
        OfferDTO offerDTO = new OfferDTO();
        offerDTOs.add(offerDTO);
        when(offeredServicesService.findAllOfferDTOs()).thenReturn(offerDTOs);
        ResponseEntity<List<OfferDTO>> response = offeredServicesController.findOfferDTO();
        verify(offeredServicesService, times(1)).findAllOfferDTOs();
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void getServiceDetailsTest() {
        ServiceDetails serviceDetails = new ServiceDetails();
        serviceDetails.setServicedetailsId(4);
        serviceDetails.setServiceDate(LocalDate.now());
        when(offeredServicesService.getServiceDetails(any())).thenReturn(serviceDetails);
        ResponseEntity<ServiceDetails> response = offeredServicesController.getServiceDetails(1);
        verify(offeredServicesService, times(1)).getServiceDetails(any());
        assertNotNull(response.getBody());
    }

    @Test
    public void bookServiceTest() {
        ServiceDetails serviceDetails = new ServiceDetails();
        serviceDetails.setServicedetailsId(4);
        serviceDetails.setServiceDate(LocalDate.now());
        when(offeredServicesService.saveServiceDetails(any())).thenReturn(serviceDetails);
        ResponseEntity<ServiceDetails> response = offeredServicesController.bookService(serviceDetails);
        verify(offeredServicesService, times(1)).saveServiceDetails(any());
        assertNotNull(response.getBody());
    }

    @Test
    public void applyOfferTest() {
        ServiceDetails serviceDetails = new ServiceDetails();
        serviceDetails.setServicedetailsId(4);
        serviceDetails.setServiceDate(LocalDate.now());
        when(offeredServicesService.saveServiceDetails(any())).thenReturn(serviceDetails);
        ResponseEntity<ServiceDetails> response = offeredServicesController.applyOffer(serviceDetails);
        verify(offeredServicesService, times(1)).saveServiceDetails(any());
        assertNotNull(response.getBody());
    }

}
