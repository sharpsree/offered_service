package com.vms.offer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="Offer", schema = "vms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Offer implements Serializable{

    @Column(name="Offerid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer offerId;

    @Column(name="Offertype")
    private String offerType;

    @Column(name="Offerpercentage")
    private BigDecimal offerPercentage;

    @Column(name="Offerstartdate")
    private LocalDate offerStartDate;

    @Column(name="Offerendtdate")
    private LocalDate offerEndtDate;

}
