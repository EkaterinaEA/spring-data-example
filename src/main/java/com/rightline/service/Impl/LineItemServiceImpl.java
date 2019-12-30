package com.rightline.service.Impl;

import com.rightline.dao.LineItemRepository;
import com.rightline.entity.shop.LineItem;
import com.rightline.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineItemServiceImpl implements LineItemService {

    @Autowired
    private LineItemRepository lineItemRepository;

    @Override
    public LineItem save(final LineItem lineItem) {
        if (lineItem.getId() == null) {
            return lineItemRepository.save(lineItem);
        } else {
            return lineItemRepository.save(lineItem);
        }
    }

    @Override
    public LineItem update(final LineItem lineItem) {
        if (lineItem.getId() != null && findById(lineItem.getId()) != null) {
            return lineItemRepository.save(lineItem);
        } else {
            return null;
        }
    }

    @Override
    public LineItem findById(final Integer id) {
        final Optional<LineItem> lineItemWrapper = lineItemRepository.findById(id);
        if (lineItemWrapper.isPresent()) {
            return lineItemWrapper.get();
        } else {
            return null;
        }
    }

    @Override
    public List<LineItem> findAll() {
        return lineItemRepository.findAll();
    }

    @Override
    public void delete(final LineItem lineItem) {
        lineItemRepository.delete(lineItem);
    }

    @Override
    public void deleteById(final Integer id) {
        lineItemRepository.deleteById(id);
    }
}

