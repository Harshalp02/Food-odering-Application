package com.harshal.repository;

import com.harshal.model.Cart;
import com.harshal.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
