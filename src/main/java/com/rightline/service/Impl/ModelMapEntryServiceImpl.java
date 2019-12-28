package com.rightline.service.Impl;

import com.rightline.dao.ModelMapEntryDAO;
import com.rightline.entity.ModelMapEntry;
import com.rightline.service.ModelMapEntryService;
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
        Optional<ModelMapEntry> modelMapEntryWrapper = modelMapEntryDAO.findById(id);
        if (modelMapEntryWrapper.isPresent()) {
            return modelMapEntryWrapper.get();
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
