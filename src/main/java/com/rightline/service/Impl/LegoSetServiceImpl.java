package com.rightline.service.Impl;


import com.rightline.dao.LegoSetRepository;
import com.rightline.entity.LegoSet;
import com.rightline.service.LegoSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegoSetServiceImpl  implements LegoSetService {

    @Autowired
    private LegoSetRepository legoSetRepository;

    @Override
    public LegoSet save(final LegoSet legoSet) {
        if (legoSet.getId() == null) {
            return legoSetRepository.save(legoSet);
        } else {
            return legoSetRepository.save(legoSet);
        }
    }

    @Override
    public LegoSet update(final LegoSet legoSet) {
        if (legoSet.getId() != null && findById(legoSet.getId()) != null) {
            return legoSetRepository.save(legoSet);
        } else {
            return null;
        }
    }

    @Override
    public LegoSet findById(final Integer id) {
        final Optional<LegoSet> legoSetWrapper = legoSetRepository.findById(id);
        if (legoSetWrapper.isPresent()) {
            return legoSetWrapper.get();
        } else {
            return null;
        }
    }

    @Override
    public List<LegoSet> findAll() {
        return legoSetRepository.findAll();
    }

    @Override
    public void deleteById(final Integer id) {
        legoSetRepository.deleteById(id);
    }

    @Override
    public void delete(final LegoSet legoSet) {
        legoSetRepository.delete(legoSet);
    }
}

