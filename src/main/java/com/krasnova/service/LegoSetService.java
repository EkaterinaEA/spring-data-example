package com.krasnova.service;

import com.krasnova.entity.LegoSet;

import java.util.List;

public interface LegoSetService {

    LegoSet save(LegoSet legoSet);

    LegoSet update(LegoSet legoSet);

    LegoSet findById(Integer id);

    List<LegoSet> findAll();

    void delete(LegoSet legoSet);

    void deleteById(Integer id);

}
