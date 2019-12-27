package com.rightline.dao;

import com.rightline.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>, JpaRepository<Customer, Integer> {
}
