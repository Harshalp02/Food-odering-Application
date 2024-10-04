package com.harshal.service;

import com.harshal.model.IngredientsCategory;
import com.harshal.model.IngredientsItem;
import com.harshal.model.Restaurant;
import com.harshal.repository.IngredientCategoryRepository;
import com.harshal.repository.IngredientItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientsService{
    @Autowired
    private IngredientItemRepository ingredientItemRepository;
    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
    private RestaurantService restaurantService;
    @Override
    public IngredientsCategory createIngredientsCategory(String name, Long restaurantId) throws Exception {
        Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
        IngredientsCategory category=new IngredientsCategory();
        category.setRestaurant(restaurant);
        category.setName(name);
        return ingredientCategoryRepository.save(category);
    }

    @Override
    public IngredientsCategory findIngredientsCategoryById(Long id) throws Exception {
        Optional<IngredientsCategory>opt=ingredientCategoryRepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("Ingredient Category not found");
        }
        return opt.get();
    }

    @Override
    public List<IngredientsCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception {
        restaurantService.findRestaurantById(id);
        return ingredientCategoryRepository.findByRestaurantId(id);
    }

    @Override
    public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
        IngredientsCategory category=findIngredientsCategoryById(categoryId);
        IngredientsItem item=new IngredientsItem();
        item.setName(ingredientName);
        item.setRestaurant(restaurant);
        item.setCategory(category);
        IngredientsItem ingredient=ingredientItemRepository.save(item);
        category.getIngredients().add(ingredient);
        return ingredient;
    }

    @Override
    public List<IngredientsItem> findRestaurantIngredients(Long restaurantId) {

        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItem updateStock(Long id) throws Exception {
        Optional<IngredientsItem>optionalIngredientsItem=ingredientItemRepository.findById(id);
        if(optionalIngredientsItem.isEmpty()){
            throw new Exception("Ingredient Item not found");
        }
        IngredientsItem ingredientsItem=optionalIngredientsItem.get();
        ingredientsItem.setInStock(!ingredientsItem.isInStock());
        return ingredientItemRepository.save(ingredientsItem);
    }
}
