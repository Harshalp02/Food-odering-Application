package com.harshal.request;

import com.harshal.model.Address;
import com.harshal.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {
    private long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
    private List<String> images;

}
