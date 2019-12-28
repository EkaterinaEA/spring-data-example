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

@RestController
@RequestMapping("/legoset")
public class LegoSetController {

    @Autowired
    LegoSetService legoSetService;

    @PostMapping
    ResponseEntity<LegoSet> save(@RequestBody LegoSet legoSet) {
        LegoSet savedLegoSet = legoSetService.save(legoSet);
        if (savedLegoSet != null) {
            return new ResponseEntity<>(savedLegoSet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<LegoSet> update(@RequestBody LegoSet legoSet) {
        LegoSet savedLegoSet = legoSetService.update(legoSet);
        if (savedLegoSet != null) {
            return new ResponseEntity<>(savedLegoSet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable (required = false) Integer id) {
        if (id == null) {
            return new ResponseEntity<List>(legoSetService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<LegoSet>(legoSetService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<LegoSet> deleteById(@PathVariable Integer id) {
        legoSetService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<LegoSet> delete(@RequestBody LegoSet legoSet) {
        legoSetService.delete(legoSet);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
