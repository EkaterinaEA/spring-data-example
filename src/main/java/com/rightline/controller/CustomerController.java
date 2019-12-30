package com.rightline.controller;

import com.rightline.entity.customer.Customer;
import com.rightline.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    ResponseEntity<Customer> save(@RequestBody final Customer customer) {
        final Customer savedCustomer = customerService.save(customer);
        return Optional.ofNullable(savedCustomer).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<Customer> update(@RequestBody final Customer customer) {
        final Customer updatedCustomer = customerService.update(customer);
        return Optional.ofNullable(updatedCustomer).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable (required = false) final Integer id) {
        final Customer foundCustomer = customerService.findById(id);
        return Optional.ofNullable(foundCustomer).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<Customer> foundCustomers = customerService.findAll();
        return Optional.ofNullable(foundCustomers).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Customer> deleteById(@PathVariable Integer id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Customer> delete(@RequestBody Customer customer) {
        customerService.delete(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
