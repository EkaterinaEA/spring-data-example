package com.rightline.controller;

import com.rightline.entity.customer.Address;
import com.rightline.service.AddressService;
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
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    ResponseEntity<Address> save(@RequestBody final Address address) {
        final Address savedAddress = addressService.save(address);
        return Optional.ofNullable(savedAddress).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<Address> update(@RequestBody final Address address) {
        final Address updatedAddress = addressService.update(address);
        return Optional.ofNullable(updatedAddress).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable(required = false) final Integer id) {
        final Address foundAddress = addressService.findById(id);
        return Optional.ofNullable(foundAddress).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<Address> foundAddresses = addressService.findAll();
        return Optional.ofNullable(foundAddresses).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Address> deleteById(@PathVariable final Integer id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Address> delete(@RequestBody final Address address) {
        addressService.delete(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
