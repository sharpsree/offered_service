package com.vms.registration.service;

//import com.vms.registration.entity.Customer;
import com.vms.registration.entity.CustomerDetails;
import com.vms.registration.repository.CustomerDetailsRepository;
//import com.vms.registration.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final CustomerDetailsRepository customerDetailsRepository;
    //private final CustomerRepository customerRepository;

    /*public Customer findCustomer(Integer vehicleId){
        return customerRepository.findByVehicleId(vehicleId);
    }


    public Customer registerCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }*/


    public CustomerDetails findCustomerDetails(Integer loginid){
        return customerDetailsRepository.findByLogInId(loginid);
    }


    public CustomerDetails registerCustomerDetails(CustomerDetails customer){
        return customerDetailsRepository.save(customer);
    }

    public CustomerDetails updateCustomerDetails(CustomerDetails customer){
        return customerDetailsRepository.save(customer);
    }

}
