package com.rightline.service;

import com.rightline.entity.shop.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order update(Order order);

    Order findById(Integer id);

    List<Order> findAll();

    void delete(Order order);

    void deleteById(Integer id);

}
