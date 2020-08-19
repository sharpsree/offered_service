package com.vms.offeredservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="Servicedetails", schema = "vms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ServiceDetails {

    @Column(name="Servicedetailsid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer servicedetailsId;

    @Column(name="Vinnumber")
    private Integer vinNumber;

    @Column(name="Servicedate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate serviceDate;

    @OneToMany(targetEntity = OfferDetails.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Servicedetails_Offerdetails",
            joinColumns = @JoinColumn(name = "Servicedetailsid"),
            inverseJoinColumns = @JoinColumn(name = "Offerdetailsid"))
    Set<OfferDetails> offerDetail;
}
