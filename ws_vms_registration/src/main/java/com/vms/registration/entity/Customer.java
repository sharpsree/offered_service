/*package com.vms.registration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name="Customer", schema = "vms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Column(name="Customerid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name="Vehicleid")
    private Integer vehicleId ;

    @Column(name="Customername", length = 20)
    @Size(message ="max_size_violation", max=20)
    @NotNull(message ="manadatory_field")
    private String customerName;

    @Column(name="Address", length = 25)
    @Size(message ="max_size_violation", max=25)
    private String address;

    @Column(name="State")
    @Size(message ="max_size_violation", max=10)
    private String state;

    @Column(name="Country")
    @Size(message ="max_size_violation", max=10)
    private String country;

    @Column(name="Emailid")
    private String emailId;

    @Column(name="Contactnumber")
    private Integer contactNumber;

    @OneToMany(targetEntity = Vehicle.class, fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    @JoinColumn(name="Customerid")
    private List<Vehicle> vehicles;

}*/
