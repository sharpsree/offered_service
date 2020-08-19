package com.vms.offeredservice.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class OfferProperties {

    @Value("${offer.baseurl}")
    private String offerBaseUrl;
}
