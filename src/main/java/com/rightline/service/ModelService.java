package com.rightline.service;

import com.rightline.entity.Model;

import java.util.List;

public interface ModelService {

    Model save(Model model);

    Model update(Model model);

    Model findById(Integer id);

    List<Model> findAll();

    void delete(Model model);

    void deleteById(Integer id);

}
