package com.krasnova.controller;


import com.krasnova.entity.ModelMapEntry;
import com.krasnova.service.ModelMapEntryService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelmapentry")
public class ModelMapEntryController {

    @Autowired
    ModelMapEntryService modelMapEntryService;

    @PostMapping
    ResponseEntity<ModelMapEntry> save(@RequestBody ModelMapEntry modelMapEntry) {
        ModelMapEntry savedModelMapEntry = modelMapEntryService.save(modelMapEntry);
        if (savedModelMapEntry != null) {
            return new ResponseEntity<>(savedModelMapEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    ResponseEntity<ModelMapEntry> update(@RequestBody ModelMapEntry modelMapEntry) {
        ModelMapEntry savedModelMapEntry = modelMapEntryService.update(modelMapEntry);
        if (modelMapEntryService != null) {
            return new ResponseEntity<>(savedModelMapEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiParam("test id description")
    @GetMapping({"/{id}", ""})
    ResponseEntity findById(@PathVariable(required = false) Integer id) {
        if (id == null) {
            return new ResponseEntity<List>(modelMapEntryService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<ModelMapEntry>(modelMapEntryService.findById(id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ModelMapEntry> deleteById(@PathVariable Integer id) {
        modelMapEntryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity<ModelMapEntry> delete(@RequestBody ModelMapEntry modelMapEntry) {
        modelMapEntryService.delete(modelMapEntry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

