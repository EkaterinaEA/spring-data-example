package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.ManualDAO;
import com.rightline.entity.LegoSet;
import com.rightline.entity.Manual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;


@SpringJUnitConfig(ApplicationRunner.class)
class ManualServiceTest {

    @MockBean
    ManualDAO manualDAO;

    @Autowired
    ManualService manualService;

    LegoSet legoSet = new LegoSet(1, "LegoSet");

    @Test
    void save() {

        Manual manual = new Manual("Author", "text", legoSet);
        Manual storedManual = new Manual(1, "Author", "text", legoSet);

        when(manualDAO.save(any(Manual.class))).thenReturn(storedManual);

        Manual savedManual = manualService.save(manual);
        assertNotNull(savedManual);

        verify(manualDAO, times(1)).save(any(Manual.class));

    }

    @Test
    void update() {

        Manual manual = new Manual(1, "Author", "text", legoSet);
        Manual updatedManual = new Manual(1, "Updated_Author", "updated_text", legoSet);

        when(manualDAO.findById(anyInt())).thenReturn(Optional.of(manual));
        when(manualDAO.save(any(Manual.class))).thenReturn(updatedManual);

        Manual savedManual = manualService.update(manual);
        assertNotNull(savedManual);

        verify(manualDAO, times(1)).findById(anyInt());
        verify(manualDAO, times(1)).save(any(Manual.class));

    }

    @Test
    void findById() {

        Manual manual = new Manual(1, "Author", "text", legoSet);

        when(manualDAO.findById(anyInt())).thenReturn(Optional.of(manual));

        Manual savedManual = manualService.findById(manual.getId());
        assertNotNull(savedManual);
        assertEquals(savedManual.getId(), manual.getId());

        verify(manualDAO, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        Manual manual1 = new Manual(1, "Author1", "text1", legoSet);
        Manual manual2 = new Manual(2, "Author2", "text2", legoSet);

        when(manualDAO.findAll()).thenReturn(Arrays.asList(manual1, manual2));

        List<Manual> savedManual = manualService.findAll();

        assertNotNull(savedManual);
        assertEquals(2, savedManual.size());

        verify(manualDAO, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(manualDAO).delete(any(Manual.class));
        manualService.delete(new Manual());
        verify(manualDAO, times(1)).delete(any(Manual.class));

    }

    @Test
    void deleteById() {

        Manual manual = new Manual(1, "Author", "text", legoSet);
        doNothing().when(manualDAO).deleteById(anyInt());
        manualService.deleteById(manual.getId());
        verify(manualDAO, times(1)).deleteById(anyInt());

    }
}