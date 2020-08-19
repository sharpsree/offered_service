package com.vms.registration.repository;

import com.vms.registration.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {
    public CustomerDetails findByLogInId(Integer vehicleId);
}
