package com.rightline.service.Impl;

import com.rightline.dao.CustomerRepository;
import com.rightline.entity.customer.Customer;
import com.rightline.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            return customerRepository.save(customer);
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        if (customer.getId() != null && findById(customer.getId()) != null) {
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public Customer findById(Integer id) {
        Optional<Customer> customerWrapper = customerRepository.findById(id);
        if (customerWrapper.isPresent()) {
            return customerWrapper.get();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}

