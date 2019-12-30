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
    private ModelMapEntryDAO modelMapEntryDAO;

    @Override
    public ModelMapEntry save(final ModelMapEntry modelMapEntry) {
        if (modelMapEntry.getId() == null) {
            return modelMapEntryDAO.save(modelMapEntry);
        } else {
            return modelMapEntryDAO.save(modelMapEntry);
        }
    }

    @Override
    public ModelMapEntry update(final ModelMapEntry modelMapEntry) {
        if (modelMapEntry.getId() != null && findById(modelMapEntry.getId()) != null) {
            return modelMapEntryDAO.save(modelMapEntry);
        } else {
            return null;
        }
    }

    @Override
    public ModelMapEntry findById(final Integer id) {
        final Optional<ModelMapEntry> modelMapEntryWrapper = modelMapEntryDAO.findById(id);
        if (modelMapEntryWrapper.isPresent()) {
            return modelMapEntryWrapper.get();
        } else {
            return null;
        }
    }

    @Override
    public List<ModelMapEntry> findAll() {
        return modelMapEntryDAO.findAll();
    }

    @Override
    public void delete(final ModelMapEntry modelMapEntry) {
        modelMapEntryDAO.delete(modelMapEntry);
    }

    @Override
    public void deleteById(final Integer id) {
        modelMapEntryDAO.deleteById(id);
    }
}

