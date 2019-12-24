package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.ModelMapEntryDAO;
import com.rightline.entity.ModelMapEntry;
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
class ModelMapEntryServiceTest {

    @MockBean
    ModelMapEntryDAO modelMapEntryDAO;

    @Autowired
    ModelMapEntryService modelMapEntryService;

    @Test
    void save() {

        ModelMapEntry modelMapEntry = new ModelMapEntry("key");
        ModelMapEntry storedModelMapEntry = new ModelMapEntry(1, "key");

        when(modelMapEntryDAO.save(any(ModelMapEntry.class))).thenReturn(storedModelMapEntry);

        ModelMapEntry savedModelMapEntry = modelMapEntryService.save(modelMapEntry);
        assertNotNull(savedModelMapEntry);

        verify(modelMapEntryDAO, times(1)).save(any(ModelMapEntry.class));

    }

    @Test
    void update() {

        ModelMapEntry modelMapEntry = new ModelMapEntry(1, "key");
        ModelMapEntry updatedModelMapEntry = new ModelMapEntry(1, "updated_key");

        when(modelMapEntryDAO.findById(anyInt())).thenReturn(Optional.of(modelMapEntry));
        when(modelMapEntryDAO.save(any(ModelMapEntry.class))).thenReturn(updatedModelMapEntry);

        ModelMapEntry savedModelMapEntry = modelMapEntryService.update(modelMapEntry);
        assertNotNull(savedModelMapEntry);

        verify(modelMapEntryDAO, times(1)).findById(anyInt());
        verify(modelMapEntryDAO, times(1)).save(any(ModelMapEntry.class));

    }

    @Test
    void findById() {

        ModelMapEntry modelMapEntry = new ModelMapEntry(1, "key");

        when(modelMapEntryDAO.findById(anyInt())).thenReturn(Optional.of(modelMapEntry));

        ModelMapEntry savedModelMapEntry = modelMapEntryService.findById(modelMapEntry.getId());
        assertNotNull(savedModelMapEntry);
        assertEquals(savedModelMapEntry.getId(), modelMapEntry.getId());

        verify(modelMapEntryDAO, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        ModelMapEntry modelMapEntry1 = new ModelMapEntry(1, "key1");
        ModelMapEntry modelMapEntry2 = new ModelMapEntry(1, "key2");

        when(modelMapEntryDAO.findAll()).thenReturn(Arrays.asList(modelMapEntry1, modelMapEntry2));

        List<ModelMapEntry> savedModelMapEntry = modelMapEntryService.findAll();

        assertNotNull(savedModelMapEntry);
        assertEquals(2, savedModelMapEntry.size());

        verify(modelMapEntryDAO, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(modelMapEntryDAO).delete(any(ModelMapEntry.class));
        modelMapEntryService.delete(new ModelMapEntry());
        verify(modelMapEntryDAO, times(1)).delete(any(ModelMapEntry.class));

    }

    @Test
    void deleteById() {

        ModelMapEntry modelMapEntry = new ModelMapEntry(1, "key");
        doNothing().when(modelMapEntryDAO).deleteById(anyInt());
        modelMapEntryService.deleteById(modelMapEntry.getId());
        verify(modelMapEntryDAO, times(1)).deleteById(anyInt());

    }
}
