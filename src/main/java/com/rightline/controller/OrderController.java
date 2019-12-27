package com.rightline.controller;


import com.rightline.entity.shop.Order;
import com.rightline.service.LineItemService;
import com.rightline.service.OrderService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    ResponseEntity<Order> save(@RequestBody Order order) {
        Order savedOrder = orderService.save(order);
        if (savedOrder != null) {
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<Order> update(@RequestBody Order order) {
        Order savedOrder = orderService.update(order);
        if (orderService != null) {
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable(required = false) Integer id) {
        if (id == null) {
            return new ResponseEntity<List>(orderService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Order>(orderService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Order> deleteById(@PathVariable Integer id) {
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Order> delete(@RequestBody Order order) {
        orderService.delete(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

