package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.LineItemRepository;
import com.rightline.entity.shop.LineItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringJUnitConfig(ApplicationRunner.class)
class LineItemServiceTest {

    @MockBean
    LineItemRepository lineItemRepository;

    @Autowired
    LineItemService lineItemService;

    @Test
    void save() {

        LineItem lineItem = new LineItem("caption", 567.89, 100);
        LineItem storedLineItem = new LineItem(1,"caption", 567.89, 100);

        when(lineItemRepository.save(any(LineItem.class))).thenReturn(storedLineItem);

        LineItem savedLineItem = lineItemService.save(lineItem);
        assertNotNull(savedLineItem);

        verify(lineItemRepository, times(1)).save(any(LineItem.class));

    }

    @Test
    void update() {

        LineItem lineItem = new LineItem(1,"caption", 567.89, 100);
        LineItem updatedLineItem = new LineItem(1,"updated_caption", 100.00, 555);

        when(lineItemRepository.findById(anyInt())).thenReturn(Optional.of(lineItem));
        when(lineItemRepository.save(any(LineItem.class))).thenReturn(updatedLineItem);

        LineItem savedLineItem = lineItemService.update(lineItem);
        assertNotNull(savedLineItem);

        verify(lineItemRepository, times(1)).findById(anyInt());
        verify(lineItemRepository, times(1)).save(any(LineItem.class));

    }

    @Test
    void findById() {

        LineItem lineItem = new LineItem(1,"caption", 567.89, 100);

        when(lineItemRepository.findById(anyInt())).thenReturn(Optional.of(lineItem));

        LineItem savedLineItem = lineItemService.findById(lineItem.getId());
        assertNotNull(savedLineItem);
        assertEquals(savedLineItem.getId(), lineItem.getId());

        verify(lineItemRepository, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        LineItem lineItem1 = new LineItem(1,"caption", 567.89, 100);
        LineItem lineItem2 = new LineItem(2,"updated_caption", 100.00, 555);

        when(lineItemRepository.findAll()).thenReturn(Arrays.asList(lineItem1, lineItem2));

        List<LineItem> savedLineItem = lineItemService.findAll();

        assertNotNull(savedLineItem);
        assertEquals(2, savedLineItem.size());

        verify(lineItemRepository, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(lineItemRepository).delete(any(LineItem.class));
        lineItemService.delete(new LineItem());
        verify(lineItemRepository, times(1)).delete(any(LineItem.class));

    }

    @Test
    void deleteById() {

        LineItem lineItem = new LineItem(1,"caption", 567.89, 100);
        doNothing().when(lineItemRepository).deleteById(anyInt());
        lineItemService.deleteById(lineItem.getId());
        verify(lineItemRepository, times(1)).deleteById(anyInt());

    }
}
