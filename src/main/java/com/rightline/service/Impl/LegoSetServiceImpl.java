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
    LegoSetRepository legoSetRepository;

    @Override
    public LegoSet save(LegoSet legoSet) {
        if (legoSet.getId() == null) {
            return legoSetRepository.save(legoSet);
        }
        return legoSetRepository.save(legoSet);
    }

    @Override
    public LegoSet update(LegoSet legoSet) {
        if (legoSet.getId() != null && findById(legoSet.getId()) != null) {
            return legoSetRepository.save(legoSet);
        }
        return null;
    }

    @Override
    public LegoSet findById(Integer id) {
        Optional<LegoSet> LegoSetWrapper = legoSetRepository.findById(id);
        if (LegoSetWrapper.isPresent()) {
            return LegoSetWrapper.get();
        }
        return null;
    }

    @Override
    public List<LegoSet> findAll() {
        return legoSetRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        legoSetRepository.deleteById(id);
    }

    @Override
    public void delete(LegoSet legoSet) {
        legoSetRepository.delete(legoSet);
    }
}

