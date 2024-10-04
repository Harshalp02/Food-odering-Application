package com.harshal.request;

import com.harshal.model.Category;
import com.harshal.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private Long restaurantId;
    private List<String> images;
    private boolean vegetarian;
    private boolean seasonal;
    private List<IngredientsItem> ingredients;

}
