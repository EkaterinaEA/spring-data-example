package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.CustomerRepository;
import com.rightline.entity.customer.Address;
import com.rightline.entity.customer.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@SpringJUnitConfig(ApplicationRunner.class)
class CustomerServiceTest {

    @MockBean
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    Address address = new Address(1, new Point(13.583333, 37.316667), "Palermo, Italy", "90121");

    @Test
    void save() {

        Customer customer = new Customer("Ivan", "Ivanov", address);
        Customer storedCustomer = new Customer(1, "Ivan", "Ivanov", address);

        when(customerRepository.save(any(Customer.class))).thenReturn(storedCustomer);

        Customer savedCustomer = customerService.save(customer);
        assertNotNull(savedCustomer);

        verify(customerRepository, times(1)).save(any(Customer.class));

    }

    @Test
    void update() {

        Customer customer = new Customer(1, "Ivan", "Ivanov", address);
        Customer updatedCustomer = new Customer(1, "Petr", "Petrov", address);

        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);

        Customer savedCustomer = customerService.update(customer);
        assertNotNull(savedCustomer);

        verify(customerRepository, times(1)).findById(anyInt());
        verify(customerRepository, times(1)).save(any(Customer.class));

    }

    @Test
    void findById() {

        Customer customer = new Customer(1, "Ivan", "Ivanov", address);

        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));

        Customer savedCustomer = customerService.findById(customer.getId());
        assertNotNull(savedCustomer);
        assertEquals(savedCustomer.getId(), customer.getId());

        verify(customerRepository, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        Customer customer1 = new Customer(1, "Ivan", "Ivanov", address);
        Customer customer2 = new Customer(2, "Petr", "Petrov", address);

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        List<Customer> savedCustomer = customerService.findAll();

        assertNotNull(savedCustomer);
        assertEquals(2, savedCustomer.size());

        verify(customerRepository, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(customerRepository).delete(any(Customer.class));
        customerService.delete(new Customer());
        verify(customerRepository, times(1)).delete(any(Customer.class));

    }

    @Test
    void deleteById() {

        Customer customer = new Customer(1, "Ivan", "Ivanov", address);
        doNothing().when(customerRepository).deleteById(anyInt());
        customerService.deleteById(customer.getId());
        verify(customerRepository, times(1)).deleteById(anyInt());

    }
}