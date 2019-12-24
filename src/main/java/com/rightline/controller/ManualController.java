package com.rightline.controller;

import com.rightline.entity.Manual;
import com.rightline.service.ManualService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manual")
public class ManualController {


    @Autowired
    private ManualService manualService;

    @PostMapping
    ResponseEntity<Manual> save(@RequestBody Manual manual) {
        Manual savedManual = manualService.save(manual);
        if (savedManual != null) {
            return new ResponseEntity<>(savedManual, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<Manual> update(@RequestBody Manual manual) {
        Manual savedManual = manualService.update(manual);
        if (savedManual != null) {
            return new ResponseEntity<>(savedManual, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable (required = false) Integer id) {
        if (id == null){
            return new ResponseEntity<List>(manualService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Manual>(manualService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Manual> deleteById (@PathVariable Integer id){
        manualService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Manual> delete (@RequestBody Manual manual){
        manualService.delete(manual);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
