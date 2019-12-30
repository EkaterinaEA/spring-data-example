package com.rightline.service.Impl;

import com.rightline.dao.ManualDAO;
import com.rightline.entity.Manual;
import com.rightline.service.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManualServiceImpl implements ManualService {

    @Autowired
    private ManualDAO manualDAO;

    @Override
    public Manual save(final Manual manual) {
        if (manual.getId() == null) {
            return manualDAO.save(manual);
        } else {
            return manualDAO.save(manual);
        }
    }

    @Override
    public Manual update(final Manual manual) {
        if (manual.getId() != null && findById(manual.getId()) != null) {
            return manualDAO.save(manual);
        } else {
            return null;
        }
    }

    @Override
    public Manual findById(final Integer id) {
        final Optional<Manual> manualWrapper = manualDAO.findById(id);
        if (manualWrapper.isPresent()) {
            return manualWrapper.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Manual> findAll() {
        return manualDAO.findAll();
    }

    @Override
    public void deleteById(final Integer id) {
        manualDAO.deleteById(id);
    }

    @Override
    public List<Manual> findAllManualsByLegoSetId(final Integer legoSetId) {
        final List<Manual> manuals = manualDAO.findAllManualsByLegoSetId(legoSetId);
        if (!manuals.isEmpty()) {
            return manuals;
        } else {
            return null;
        }
    }

    @Override
    public void delete(final Manual manual) {
        manualDAO.delete(manual);
    }
}

