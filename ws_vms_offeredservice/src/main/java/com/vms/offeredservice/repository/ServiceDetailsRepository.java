package com.vms.offeredservice.repository;

import com.vms.offeredservice.entity.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Integer> {
    List<ServiceDetails> findByVinNumber(Integer vinNumber);
}
