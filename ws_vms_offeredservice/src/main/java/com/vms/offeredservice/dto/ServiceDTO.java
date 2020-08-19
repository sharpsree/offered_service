package com.vms.offeredservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vms.offer.dto.OfferDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ServiceDTO implements Serializable {

    private Integer servicedetailsId;

    private Integer vinNumber;

    private List<Integer> offerIds;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date serviceDate;

    private List<OfferDTO> offers;
}
