package com.rightline.controller;


import com.rightline.entity.shop.Order;
import com.rightline.service.LineItemService;
import com.rightline.service.OrderService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    ResponseEntity<Order> save(@RequestBody final Order order) {
        final Order savedOrder = orderService.save(order);
        return Optional.ofNullable(savedOrder).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<Order> update(@RequestBody final Order order) {
        final Order updatedOrder = orderService.update(order);
        return Optional.ofNullable(updatedOrder).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable(required = false) final Integer id) {
        final Order foundOrder = orderService.findById(id);
        return Optional.ofNullable(foundOrder).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<Order> foundOrders = orderService.findAll();
        return Optional.ofNullable(foundOrders).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Order> deleteById(@PathVariable final Integer id) {
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Order> delete(@RequestBody final Order order) {
        orderService.delete(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

