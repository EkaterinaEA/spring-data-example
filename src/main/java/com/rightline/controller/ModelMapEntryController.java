package com.rightline.controller;


import com.rightline.entity.ModelMapEntry;
import com.rightline.service.ModelMapEntryService;
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
@RequestMapping("/modelmapentry")
public class ModelMapEntryController {

    @Autowired
    private ModelMapEntryService modelMapEntryService;

    @PostMapping
    ResponseEntity<ModelMapEntry> save(@RequestBody final ModelMapEntry modelMapEntry) {
        final ModelMapEntry savedModelMapEntry = modelMapEntryService.save(modelMapEntry);
        return Optional.ofNullable(savedModelMapEntry).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<ModelMapEntry> update(@RequestBody final ModelMapEntry modelMapEntry) {
        final ModelMapEntry updatedModelMapEntry = modelMapEntryService.update(modelMapEntry);
        return Optional.ofNullable(updatedModelMapEntry).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}"})
    ResponseEntity findById(@PathVariable(required = false) final Integer id) {
        final ModelMapEntry foundModelMapEntry = modelMapEntryService.findById(id);
        return Optional.ofNullable(foundModelMapEntry).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping({""})
    ResponseEntity findAll() {
        final List<ModelMapEntry> foundModelMapsEntry = modelMapEntryService.findAll();
        return Optional.ofNullable(foundModelMapsEntry).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ModelMapEntry> deleteById(@PathVariable final Integer id) {
        modelMapEntryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<ModelMapEntry> delete(@RequestBody final ModelMapEntry modelMapEntry) {
        modelMapEntryService.delete(modelMapEntry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

