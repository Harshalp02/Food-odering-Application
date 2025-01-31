package com.harshal.service;

import com.harshal.model.Order;
import com.harshal.model.User;
import com.harshal.request.OrderRequest;

import java.util.List;

public interface OrderService {
    public Order createOrder(OrderRequest order, User user) throws Exception;

    public Order updateOrder(Long orderId,String orderStatus)throws  Exception;

    public void cancelOrder(Long orderId)throws Exception;

    public List<Order> getUsersOrders(Long userId)throws Exception;

    public List<Order>getRestaurantOrder(Long restaurantId,String orderStatus)throws Exception;

    public Order findOrderById(Long orderId)throws Exception;
}
