package com.krasnova.service.Impl;

import com.krasnova.dao.LegoSetRepository;
import com.krasnova.dao.ManualDAO;
import com.krasnova.entity.Manual;
import com.krasnova.service.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManualServiceImpl  implements ManualService {

    @Autowired
    ManualDAO manualDAO;

    @Override
    public Manual save(Manual manual) {
        if (manual.getId() == null) {
            return manualDAO.save(manual);
        }
        return manualDAO.save(manual);
    }

    @Override
    public Manual update(Manual manual) {
        if (manual.getId() != null && findById(manual.getId()) != null) {
            return manualDAO.save(manual);
        }
        return null;
    }

    @Override
    public Manual findById(Integer id) {
        Optional<Manual> ManualWrapper = manualDAO.findById(id);
        if (ManualWrapper.isPresent()) {
            return ManualWrapper.get();
        }
        return null;
    }

    @Override
    public List<Manual> findAll() {
        return manualDAO.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        manualDAO.deleteById(id);
    }

    @Override
    public void delete(Manual manual) {
        manualDAO.delete(manual);
    }
}

