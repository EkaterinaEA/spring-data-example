package com.rightline.controller;

import com.rightline.entity.LegoSet;
import com.rightline.service.LegoSetService;
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
@RequestMapping("/legoset")
public class LegoSetController {

    @Autowired
    private LegoSetService legoSetService;

    @PostMapping
    ResponseEntity<LegoSet> save(@RequestBody final LegoSet legoSet) {
        final LegoSet savedLegoSet = legoSetService.save(legoSet);
        return Optional.ofNullable(savedLegoSet).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<LegoSet> update(@RequestBody final LegoSet legoSet) {
        final LegoSet updatedLegoSet = legoSetService.update(legoSet);
        return Optional.ofNullable(updatedLegoSet).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable(required = false) final Integer id) {
        final LegoSet foundLegoSet = legoSetService.findById(id);
        return Optional.ofNullable(foundLegoSet).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<LegoSet> foundLegoSets = legoSetService.findAll();
        return Optional.ofNullable(foundLegoSets).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<LegoSet> deleteById(@PathVariable final Integer id) {
        legoSetService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<LegoSet> delete(@RequestBody final LegoSet legoSet) {
        legoSetService.delete(legoSet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
