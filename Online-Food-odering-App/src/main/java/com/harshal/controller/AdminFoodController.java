package com.harshal.controller;

import com.harshal.model.Food;
import com.harshal.model.Restaurant;
import com.harshal.model.User;
import com.harshal.request.CreateFoodRequest;
import com.harshal.response.MessageResponse;
import com.harshal.service.FoodService;
import com.harshal.service.RestaurantService;
import com.harshal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(
            @RequestBody CreateFoodRequest req,
            @RequestHeader("Authorization") String jwt
            ) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantByUserId(req.getRestaurantId());
        Food food=foodService.createFood(req,req.getCategory(),restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);
        MessageResponse res=new MessageResponse();
        res.setMessage("Food Deleted Successfully");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailabilityStatus(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        Food food=foodService.updateAvailabilityStatus(id);


        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
}
