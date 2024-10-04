package com.harshal.service;

import com.harshal.model.Category;
import com.harshal.model.Food;
import com.harshal.model.Restaurant;
import com.harshal.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    void deleteFood(Long id)throws Exception;
    public List<Food> getRestaurantsFood(Long restaurantId,boolean isVegetarian,boolean isNonVeg,boolean isSeasonal,String foodCategory);
    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodID)throws Exception;
    public Food updateAvailabilityStatus(Long foodId)throws Exception;
}
