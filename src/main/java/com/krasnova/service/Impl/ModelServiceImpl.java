package com.krasnova.service.Impl;

import com.krasnova.dao.ModelDAO;
import com.krasnova.entity.Model;
import com.krasnova.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelDAO modelDAO;

    @Override
    public Model save(Model model) {
        if (model.getId() == null) {
            return modelDAO.save(model);
        }
        return modelDAO.save(model);
    }

    @Override
    public Model update(Model model) {
        if (model.getId() != null && findById(model.getId()) != null) {
            return modelDAO.save(model);
        }
        return null;
    }

    @Override
    public Model findById(Integer id) {
        Optional<Model> ModelWrapper = modelDAO.findById(id);
        if (ModelWrapper.isPresent()) {
            return ModelWrapper.get();
        }
        return null;
    }

    @Override
    public List<Model> findAll() {
        return modelDAO.findAll();
    }

    @Override
    public void delete(Model model) {
        modelDAO.delete(model);
    }

    @Override
    public void deleteById(Integer id) {
        modelDAO.deleteById(id);
    }
}
