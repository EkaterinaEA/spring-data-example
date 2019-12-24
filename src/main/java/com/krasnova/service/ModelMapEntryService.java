package com.krasnova.service;

import com.krasnova.entity.ModelMapEntry;

import java.util.List;

public interface ModelMapEntryService {

    ModelMapEntry save(ModelMapEntry modelMapEntry);

    ModelMapEntry update(ModelMapEntry modelMapEntry);

    ModelMapEntry findById(Integer id);

    List<ModelMapEntry> findAll();

    void delete(ModelMapEntry modelMapEntry);

    void deleteById(Integer id);

}
