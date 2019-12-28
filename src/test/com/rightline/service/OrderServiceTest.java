package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.OrderRepository;
import com.rightline.entity.shop.LineItem;
import com.rightline.entity.shop.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Calendar;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;


@SpringJUnitConfig(ApplicationRunner.class)
class OrderServiceTest {

    @MockBean
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    LineItem lineItem = new LineItem(1,"caption", 567.89, 100);

    @Test
    void save() {

        Order order = new Order("customerId", Calendar.getInstance().getTime(), lineItem);
        Order storedOrder = new Order(1, "customerId", Calendar.getInstance().getTime(), lineItem);

        when(orderRepository.save(any(Order.class))).thenReturn(storedOrder);

        Order savedOrder = orderService.save(order);
        assertNotNull(savedOrder);

        verify(orderRepository, times(1)).save(any(Order.class));

    }

    @Test
    void update() {

        Order order = new Order(1, "customerId", Calendar.getInstance().getTime(), lineItem);
        Order updatedOrder = new Order(1, "updated_customerId", Calendar.getInstance().getTime(), lineItem);

        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(updatedOrder);

        Order savedOrder = orderService.update(order);
        assertNotNull(savedOrder);

        verify(orderRepository, times(1)).findById(anyInt());
        verify(orderRepository, times(1)).save(any(Order.class));

    }

    @Test
    void findById() {

        Order order = new Order(1, "customerId", Calendar.getInstance().getTime(), lineItem);

        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));

        Order savedOrder = orderService.findById(order.getId());
        assertNotNull(savedOrder);
        assertEquals(savedOrder.getId(), order.getId());

        verify(orderRepository, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        Order order1 = new Order(1, "customerId", Calendar.getInstance().getTime(), lineItem);
        Order order2 = new Order(2, "customerId", Calendar.getInstance().getTime(), lineItem);

        when(orderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        List<Order> savedOrder = orderService.findAll();

        assertNotNull(savedOrder);
        assertEquals(2, savedOrder.size());

        verify(orderRepository, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(orderRepository).delete(any(Order.class));
        orderService.delete(new Order());
        verify(orderRepository, times(1)).delete(any(Order.class));

    }

    @Test
    void deleteById() {

        Order order = new Order(1, "customerId", Calendar.getInstance().getTime(), lineItem);
        doNothing().when(orderRepository).deleteById(anyInt());
        orderService.deleteById(order.getId());
        verify(orderRepository, times(1)).deleteById(anyInt());

    }

}