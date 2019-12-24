package com.krasnova.service.Impl;

import com.krasnova.dao.ModelMapEntryDAO;
import com.krasnova.entity.ModelMapEntry;
import com.krasnova.service.ModelMapEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelMapEntryServiceImpl implements ModelMapEntryService {

    @Autowired
    ModelMapEntryDAO modelMapEntryDAO;

    @Override
    public ModelMapEntry save(ModelMapEntry modelMapEntry) {
        if (modelMapEntry.getId() == null) {
            return modelMapEntryDAO.save(modelMapEntry);
        }
        return modelMapEntryDAO.save(modelMapEntry);
    }

    @Override
    public ModelMapEntry update(ModelMapEntry modelMapEntry) {
        if (modelMapEntry.getId() != null && findById(modelMapEntry.getId()) != null) {
            return modelMapEntryDAO.save(modelMapEntry);
        }
        return null;
    }

    @Override
    public ModelMapEntry findById(Integer id) {
        Optional<ModelMapEntry> ModelMapEntryWrapper = modelMapEntryDAO.findById(id);
        if (ModelMapEntryWrapper.isPresent()) {
            return ModelMapEntryWrapper.get();
        }
        return null;
    }

    @Override
    public List<ModelMapEntry> findAll() {
        return modelMapEntryDAO.findAll();
    }

    @Override
    public void delete(ModelMapEntry modelMapEntry) {
        modelMapEntryDAO.delete(modelMapEntry);
    }

    @Override
    public void deleteById(Integer id) {
        modelMapEntryDAO.deleteById(id);
    }
}

