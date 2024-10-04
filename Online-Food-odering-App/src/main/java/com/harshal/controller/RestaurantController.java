package com.harshal.controller;

import com.harshal.dto.RestaurantDto;
import com.harshal.model.Restaurant;
import com.harshal.model.User;
import com.harshal.request.CreateRestaurantRequest;
import com.harshal.service.RestaurantService;
import com.harshal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestParam String keyword,
            @RequestHeader("Authorization")String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant=restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurant(

            @RequestHeader("Authorization")String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant=restaurantService.getAllRestaurant();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(
            @PathVariable Long id,
            @RequestHeader("Authorization")String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorites(
            @PathVariable Long id,
            @RequestHeader("Authorization")String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        RestaurantDto restaurant=restaurantService.addToFavorites(id,user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
