package com.harshal.controller;

import com.harshal.model.CartItem;
import com.harshal.model.Order;
import com.harshal.model.User;
import com.harshal.request.AddCartItemRequest;
import com.harshal.request.OrderRequest;
import com.harshal.service.OrderService;
import com.harshal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> addItemToCart(
            @RequestBody OrderRequest req,
            @RequestHeader("Authorization") String jwt
    )throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        Order order=orderService.createOrder(req,user);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
            @RequestHeader("Authorization") String jwt
    )throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        List<Order> order=orderService.getUsersOrders(user.getId());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
