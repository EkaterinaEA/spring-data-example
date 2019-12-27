package com.rightline.controller;

import com.rightline.entity.customer.Customer;
import com.rightline.service.CustomerService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        if (savedCustomer != null) {
            return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<Customer> update(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.update(customer);
        if (savedCustomer != null) {
            return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable (required = false) Integer id) {
        if (id == null){
            return new ResponseEntity<List>(customerService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(customerService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Customer> deleteById (@PathVariable Integer id){
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Customer> delete (@RequestBody Customer customer){
        customerService.delete(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
