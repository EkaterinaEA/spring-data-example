package com.rightline.dao;

import com.rightline.entity.customer.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer>, JpaRepository<Address, Integer> {
}
