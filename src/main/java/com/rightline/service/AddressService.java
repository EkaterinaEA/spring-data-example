package com.rightline.service;

import com.rightline.entity.customer.Address;

import java.util.List;

public interface AddressService {

    Address save(Address address);

    Address update(Address address);

    Address findById(Integer id);

    List<Address> findAll();

    void delete(Address address);

    void deleteById(Integer id);

}
