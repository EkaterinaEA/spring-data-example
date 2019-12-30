package com.rightline.controller;


import com.rightline.entity.shop.LineItem;
import com.rightline.service.LineItemService;
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
@RequestMapping("/lineitem")
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;

    @PostMapping
    ResponseEntity<LineItem> save(@RequestBody final LineItem lineItem) {
        final LineItem savedLineItem = lineItemService.save(lineItem);
        return Optional.ofNullable(savedLineItem).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<LineItem> update(@RequestBody final LineItem lineItem) {
        final LineItem updatedLineItem = lineItemService.update(lineItem);
        return Optional.ofNullable(updatedLineItem).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable(required = false) final Integer id) {
        final LineItem foundLineItem = lineItemService.findById(id);
        return Optional.ofNullable(foundLineItem).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<LineItem> foundLinesItem = lineItemService.findAll();
        return Optional.ofNullable(foundLinesItem).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
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
