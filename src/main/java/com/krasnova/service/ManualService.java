package com.krasnova.service;

import com.krasnova.entity.Manual;

import java.util.List;

public interface ManualService {

    Manual save(Manual manual);

    Manual update(Manual manual);

    Manual findById(Integer id);

    List<Manual> findAll();

    void delete(Manual manual);

    void deleteById(Integer id);

}
