package com.harshal.controller;

import com.harshal.model.Food;
import com.harshal.model.Restaurant;
import com.harshal.model.User;
import com.harshal.request.CreateFoodRequest;
import com.harshal.service.FoodService;
import com.harshal.service.RestaurantService;
import com.harshal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(
            @RequestParam String name,
            @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        List<Food> foods=foodService.searchFood(name);
        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam boolean vegetarian,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonVeg,
            @RequestParam(required = false) String food_category,
            @PathVariable Long restaurantId,
            @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        List<Food> foods=foodService.getRestaurantsFood(restaurantId,vegetarian,nonVeg,seasonal,food_category);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
