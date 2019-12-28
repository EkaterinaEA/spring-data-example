package com.rightline.controller;


import com.rightline.entity.Model;
import com.rightline.service.ModelService;
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
@RequestMapping("/model")
public class ModelController {

    @Autowired
    ModelService modelService;

    @PostMapping
    ResponseEntity<Model> save(@RequestBody Model model) {
        Model savedModel = modelService.save(model);
        if (savedModel != null) {
            return new ResponseEntity<>(savedModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<Model> update(@RequestBody Model model) {
        Model savedModel = modelService.update(model);
        if (savedModel != null) {
            return new ResponseEntity<>(savedModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable(required = false) Integer id) {
        if (id == null) {
            return new ResponseEntity<List>(modelService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Model>(modelService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Model> deleteById(@PathVariable Integer id) {
        modelService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Model> delete(@RequestBody Model model) {
        modelService.delete(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-all-models-by-legosetid/{cartId}")
    ResponseEntity<Model> findAllModelsByLegoSetId(@PathVariable Integer legoSetId){
        return new ResponseEntity(modelService.findAllModelsByLegoSetId(legoSetId), HttpStatus.OK);
    }
}
