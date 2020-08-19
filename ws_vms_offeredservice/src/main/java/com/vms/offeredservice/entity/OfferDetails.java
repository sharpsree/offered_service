package com.vms.offeredservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
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

    @JsonIgnore
    @ManyToOne(targetEntity =ServiceDetails.class , cascade = CascadeType.ALL)
    @JoinTable(
            name = "Servicedetails_Offerdetails",
            joinColumns = @JoinColumn(name = "Offerdetailsid"),
            inverseJoinColumns = @JoinColumn(name = "Servicedetailsid"))
    ServiceDetails serviceDetail;

    public Integer getOfferdetailsId() {
        return offerdetailsId;
    }

    public void setOfferdetailsId(Integer offerdetailsId) {
        this.offerdetailsId = offerdetailsId;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public BigDecimal getOfferPercentage() {
        return offerPercentage;
    }

    public void setOfferPercentage(BigDecimal offerPercentage) {
        this.offerPercentage = offerPercentage;
    }

    public LocalDate getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(LocalDate offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    public LocalDate getOfferEndtDate() {
        return offerEndtDate;
    }

    public void setOfferEndtDate(LocalDate offerEndtDate) {
        this.offerEndtDate = offerEndtDate;
    }

    @JsonIgnore
    public ServiceDetails getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(ServiceDetails serviceDetail) {
        this.serviceDetail = serviceDetail;
    }
}
