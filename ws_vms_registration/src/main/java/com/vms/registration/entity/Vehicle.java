/*package com.vms.registration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Vehicle", schema = "vms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehicle {

    @Column(name="Vinnumber")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer VinNumber;

    @Column(name="Vehiclemodel")
    private String vehicleModel;

    @Column(name="Customerid")
    private Integer CustomerId;

    @Column(name="Vehiclemake")
    private String vehicleMake;

}*/