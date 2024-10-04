package com.harshal.request;

import com.harshal.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;
    private Address delivaryAddress;
}
