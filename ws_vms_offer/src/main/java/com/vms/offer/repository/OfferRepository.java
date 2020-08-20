package com.vms.offer.repository;

import com.vms.offer.entity.OfferDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferDetails, Integer> {
}