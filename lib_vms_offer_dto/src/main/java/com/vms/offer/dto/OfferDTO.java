package com.vms.offer.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OfferDTO implements Serializable {

    private Integer offerdetailsId;

    private String offerType;

    private BigDecimal offerPercentage;

    private LocalDate offerStartDate;

    private LocalDate offerEndtDate;
}
