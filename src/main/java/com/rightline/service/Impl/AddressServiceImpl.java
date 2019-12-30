package com.rightline.service.Impl;


import com.rightline.dao.AddressRepository;
import com.rightline.entity.customer.Address;
import com.rightline.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(final Address address) {
        if (address.getId() == null) {
            return addressRepository.save(address);
        }
        return addressRepository.save(address);
    }

    @Override
    public Address update(final Address address) {
        if (address.getId() != null && findById(address.getId()) != null) {
            return addressRepository.save(address);
        }
        return null;
    }

    @Override
    public Address findById(final Integer id) {
        final Optional<Address> addressWrapper = addressRepository.findById(id);
        if (addressWrapper.isPresent()) {
            return addressWrapper.get();
        }
        return null;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(final Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void delete(final Address address) {
        addressRepository.delete(address);
    }
}

