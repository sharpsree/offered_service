package com.vms.offer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name="Offerdetails", schema = "vms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OfferDetails {

    @Column(name="Offerdetailsid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer offerdetailsId;

    @Column(name="Offertype")
    private String offerType;

    @Column(name="Offerpercentage")
    private BigDecimal offerPercentage;

    @Column(name="Offerstartdate")
    private LocalDate offerStartDate;

    @Column(name="Offerendtdate")
    private LocalDate offerEndtDate;
}
