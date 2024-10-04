package com.harshal.service;

import com.harshal.model.IngredientsCategory;
import com.harshal.model.IngredientsItem;

import java.util.List;

public interface IngredientsService {
    public IngredientsCategory createIngredientsCategory(String name,Long restaurantId)throws Exception;
    public IngredientsCategory findIngredientsCategoryById(Long id)throws  Exception;
    public List<IngredientsCategory> findIngredientsCategoryByRestaurantId(Long id)throws  Exception;
    public IngredientsItem createIngredientItem(Long restaurantId,String ingredientName,Long categoryId)throws Exception;
    public List<IngredientsItem> findRestaurantIngredients(Long restaurantId);

    public IngredientsItem updateStock(Long id)throws Exception;
}
