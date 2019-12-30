package com.rightline.service.Impl;

import com.rightline.dao.OrderRepository;
import com.rightline.entity.shop.Order;
import com.rightline.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(final Order order) {
        if (order.getId() == null) {
            return orderRepository.save(order);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order update(final Order order) {
        if (order.getId() != null && findById(order.getId()) != null) {
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order findById(final Integer id) {
        final Optional<Order> orderWrapper = orderRepository.findById(id);
        if (orderWrapper.isPresent()) {
            return orderWrapper.get();
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(final Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void deleteById(final Integer id) {
        orderRepository.deleteById(id);
    }
}
