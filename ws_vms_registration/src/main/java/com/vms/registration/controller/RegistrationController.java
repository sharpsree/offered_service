package com.vms.registration.controller;

//import com.vms.registration.entity.Customer;
import com.vms.registration.entity.CustomerDetails;
import com.vms.registration.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Slf4j
@RestController
@Validated
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

  /*  //@PostMapping ("/registercustomer")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        log.info(" Register Customer");
        return new ResponseEntity<>(registrationService.registerCustomer(customer), HttpStatus.CREATED);
    }

    //@GetMapping("/findcustomer/{loginid}")
    public ResponseEntity<Customer> findCustomer(@PathVariable  @Min(1) Integer loginid) {
        log.info(" find CustomerDetails  for loginid: {}", loginid);
        return new ResponseEntity<>(registrationService.findCustomer(loginid), HttpStatus.OK);
    }

   // @PutMapping("/updatecustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        log.info(" Update Customer");
        return new ResponseEntity<>(registrationService.updateCustomer(customer), HttpStatus.ACCEPTED);
    }*/

    @PostMapping ("/registercustomerdetails")
    public ResponseEntity<CustomerDetails> registerCustomerDetails(@RequestBody CustomerDetails customer) {
        log.info(" Register Customer");
        return new ResponseEntity<>(registrationService.registerCustomerDetails(customer), HttpStatus.CREATED);
    }

    @GetMapping("/findcustomerdetails/{loginid}")
    public ResponseEntity<CustomerDetails> findCustomerDetails(@PathVariable  @Min(1) Integer loginid) {
        log.info(" find CustomerDetails  for loginid: {}", loginid);
        return new ResponseEntity<>(registrationService.findCustomerDetails(loginid), HttpStatus.OK);
    }

    @PutMapping("/updatecustomerdetails")
    public ResponseEntity<CustomerDetails> updateCustomer(@RequestBody CustomerDetails customer) {
        log.info(" Update Customer");
        return new ResponseEntity<>(registrationService.updateCustomerDetails(customer), HttpStatus.ACCEPTED);
    }
}
