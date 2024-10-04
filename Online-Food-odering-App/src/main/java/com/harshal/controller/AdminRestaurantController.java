package com.harshal.controller;

import com.harshal.model.Restaurant;
import com.harshal.model.User;
import com.harshal.request.CreateRestaurantRequest;
import com.harshal.response.MessageResponse;
import com.harshal.service.RestaurantService;
import com.harshal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization")String jwt
            ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.createRestaurant(req,user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.updateRestaurant(id,req);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(

            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        restaurantService.deleteRestaurant(id);
        MessageResponse res=new MessageResponse();
        res.setMessage("Restaurant deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(

            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(

            @RequestHeader("Authorization")String jwt

    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantByUserId(user.getId());

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
}
