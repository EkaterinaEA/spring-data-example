package com.rightline.controller;

import com.rightline.entity.Manual;
import com.rightline.service.ManualService;
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
@RequestMapping("/manual")
public class ManualController {

    @Autowired
    private ManualService manualService;

    @PostMapping
    ResponseEntity<Manual> save(@RequestBody final Manual manual) {
        final Manual savedManual = manualService.save(manual);
        return Optional.ofNullable(savedManual).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<Manual> update(@RequestBody final Manual manual) {
        Manual updatedManual = manualService.update(manual);
        return Optional.ofNullable(updatedManual).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable(required = false) final Integer id) {
        final Manual foundManual = manualService.findById(id);
        return Optional.ofNullable(foundManual).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<Manual> foundManuals = manualService.findAll();
        return Optional.ofNullable(foundManuals).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Manual> deleteById(@PathVariable final Integer id) {
        manualService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Manual> delete(@RequestBody final Manual manual) {
        manualService.delete(manual);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-all-manuals-by-legosetid/{cartId}")
    public ResponseEntity<List<Manual>> findAllManualsByLegoSetId(@PathVariable final Integer legoSetId) {
        final List<Manual> foundManuals = manualService.findAllManualsByLegoSetId(legoSetId);
        return Optional.ofNullable(foundManuals).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
