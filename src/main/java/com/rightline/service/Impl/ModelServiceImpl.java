package com.rightline.service.Impl;

import com.rightline.dao.ModelDAO;
import com.rightline.entity.Model;
import com.rightline.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelDAO modelDAO;

    @Override
    public Model save(final Model model) {
        if (model.getId() == null) {
            return modelDAO.save(model);
        } else {
            return modelDAO.save(model);
        }
    }

    @Override
    public Model update(final Model model) {
        if (model.getId() != null && findById(model.getId()) != null) {
            return modelDAO.save(model);
        } else {
            return null;
        }
    }

    @Override
    public Model findById(final Integer id) {
        final Optional<Model> modelWrapper = modelDAO.findById(id);
        if (modelWrapper.isPresent()) {
            return modelWrapper.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Model> findAll() {
        return modelDAO.findAll();
    }

    @Override
    public void delete(final Model model) {
        modelDAO.delete(model);
    }

    @Override
    public void deleteById(final Integer id) {
        modelDAO.deleteById(id);
    }

    @Override
    public List<Model> findAllModelsByLegoSetId(final Integer legoSetId) {
        final List<Model> models = modelDAO.findAllModelsByLegoSetId(legoSetId);
        if (!models.isEmpty()) {
            return models;
        } else {
            return null;
        }
    }
}
