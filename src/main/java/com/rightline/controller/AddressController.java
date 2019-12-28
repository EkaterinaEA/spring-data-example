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

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    ResponseEntity<Address> save(@RequestBody Address address) {
        Address savedAddress = addressService.save(address);
        if (savedAddress != null) {
            return new ResponseEntity<>(savedAddress, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<Address> update(@RequestBody Address address) {
        Address savedAddress = addressService.update(address);
        if (savedAddress != null) {
            return new ResponseEntity<>(savedAddress, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable (required = false) Integer id) {
        if (id == null){
            return new ResponseEntity<List>(addressService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Address>(addressService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Address> deleteById (@PathVariable Integer id){
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Address> delete (@RequestBody Address address){
        addressService.delete(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
