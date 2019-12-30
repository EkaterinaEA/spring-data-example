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
import java.util.Optional;

@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping
    ResponseEntity<Model> save(@RequestBody final Model model) {
        final Model savedModel = modelService.save(model);
        return Optional.ofNullable(savedModel).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<Model> update(@RequestBody final Model model) {
        final Model updatedModel = modelService.update(model);
        return Optional.ofNullable(updatedModel).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable(required = false) final Integer id) {
        final Model foundModel = modelService.findById(id);
        return Optional.ofNullable(foundModel).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<Model> foundModels = modelService.findAll();
        return Optional.ofNullable(foundModels).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Model> deleteById(@PathVariable final Integer id) {
        modelService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<Model> delete(@RequestBody final Model model) {
        modelService.delete(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-all-models-by-legosetid/{cartId}")
    ResponseEntity<List<Model>> findAllModelsByLegoSetId(@PathVariable final Integer legoSetId) {
        final List<Model> foundModels = modelService.findAllModelsByLegoSetId(legoSetId);
        return Optional.ofNullable(foundModels).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
