package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.AddressRepository;
import com.rightline.entity.customer.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;


@SpringJUnitConfig(ApplicationRunner.class)
class AddressServiceTest {

    @MockBean
    AddressRepository addressRepository;

    @Autowired
    AddressService addressService;

    @Test
    void save() {

        Address address = new Address(new Point(13.583333, 37.316667), "Palermo, Italy", "90121");
        Address storedAddress = new Address(1, new Point(13.583333, 37.316667), "Palermo, Italy", "90121");

        when(addressRepository.save(any(Address.class))).thenReturn(storedAddress);

        Address savedAddress = addressService.save(address);
        assertNotNull(savedAddress);

        verify(addressRepository, times(1)).save(any(Address.class));

    }

    @Test
    void update() {

        Address address = new Address(1, new Point(13.583333, 37.316667), "Palermo, Italy", "90121");
        Address updatedAddress = new Address(1, new Point(13.361389, 38.115556), "Arigento, Italy", "92100");

        when(addressRepository.findById(anyInt())).thenReturn(Optional.of(address));
        when(addressRepository.save(any(Address.class))).thenReturn(updatedAddress);

        Address savedAddress = addressService.update(address);
        assertNotNull(savedAddress);

        verify(addressRepository, times(1)).findById(anyInt());
        verify(addressRepository, times(1)).save(any(Address.class));

    }

    @Test
    void findById() {

        Address address = new Address(1, new Point(13.583333, 37.316667), "Palermo, Italy", "90121");

        when(addressRepository.findById(anyInt())).thenReturn(Optional.of(address));

        Address savedAddress = addressService.findById(address.getId());
        assertNotNull(savedAddress);
        assertEquals(savedAddress.getId(), address.getId());

        verify(addressRepository, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        Address address1 = new Address(1, new Point(13.583333, 37.316667), "Palermo, Italy", "90121");
        Address address2 = new Address(2, new Point(13.361389, 38.115556), "Arigento, Italy", "92100");

        when(addressRepository.findAll()).thenReturn(Arrays.asList(address1, address2));

        List<Address> savedAddress = addressService.findAll();

        assertNotNull(savedAddress);
        assertEquals(2, savedAddress.size());

        verify(addressRepository, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(addressRepository).delete(any(Address.class));
        addressService.delete(new Address());
        verify(addressRepository, times(1)).delete(any(Address.class));

    }

    @Test
    void deleteById() {

        Address address = new Address(1, new Point(13.583333, 37.316667), "Palermo, Italy", "90121");
        doNothing().when(addressRepository).deleteById(anyInt());
        addressService.deleteById(address.getId());
        verify(addressRepository, times(1)).deleteById(anyInt());

    }
}