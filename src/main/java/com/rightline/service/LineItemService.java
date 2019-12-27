package com.rightline.service;

import com.rightline.entity.shop.LineItem;

import java.util.List;

public interface LineItemService {

    LineItem save(LineItem lineItem);

    LineItem update(LineItem lineItem);

    LineItem findById(Integer id);

    List<LineItem> findAll();

    void delete(LineItem lineItem);

    void deleteById(Integer id);

}
