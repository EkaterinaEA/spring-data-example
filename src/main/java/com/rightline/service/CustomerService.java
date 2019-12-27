package com.rightline.service;

import com.rightline.entity.customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();

    void delete(Customer customer);

    void deleteById(Integer id);

}
