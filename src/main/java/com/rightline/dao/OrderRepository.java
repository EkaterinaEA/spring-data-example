package com.rightline.dao;

import com.rightline.entity.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer>, JpaRepository<Order, Integer> {
}
