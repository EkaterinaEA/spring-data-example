package com.rightline.controller;


import com.rightline.entity.shop.LineItem;
import com.rightline.service.LineItemService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lineitem")
public class LineItemController {

    @Autowired
    LineItemService lineItemService;

    @PostMapping
    ResponseEntity<LineItem> save(@RequestBody LineItem lineItem) {
        LineItem savedLineItem = lineItemService.save(lineItem);
        if (savedLineItem != null) {
            return new ResponseEntity<>(savedLineItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<LineItem> update(@RequestBody LineItem lineItem) {
        LineItem savedLineItem = lineItemService.update(lineItem);
        if (savedLineItem != null) {
            return new ResponseEntity<>(savedLineItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable(required = false) Integer id) {
        if (id == null) {
            return new ResponseEntity<List>(lineItemService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<LineItem>(lineItemService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<LineItem> deleteById(@PathVariable Integer id) {
        lineItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<LineItem> delete(@RequestBody LineItem lineItem) {
        lineItemService.delete(lineItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
