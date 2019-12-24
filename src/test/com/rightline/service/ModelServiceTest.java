package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.ModelDAO;
import com.rightline.entity.LegoSet;
import com.rightline.entity.Model;
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
class ModelServiceTest {

    @MockBean
    ModelDAO modelDAO;

    @Autowired
    ModelService modelService;

    LegoSet legoSet = new LegoSet(1,"LegoSet");
    ModelMapEntry modelMapEntry = new ModelMapEntry(1, "key");

    @Test
    void save() {

        Model model = new Model("model", "description", modelMapEntry, legoSet);
        Model storedModel = new Model(1, "model", "description", modelMapEntry, legoSet);

        when(modelDAO.save(any(Model.class))).thenReturn(storedModel);

        Model savedModel = modelService.save(model);
        assertNotNull(savedModel);

        verify(modelDAO, times(1)).save(any(Model.class));

    }

    @Test
    void update() {

        Model model = new Model(1, "model", "description", modelMapEntry, legoSet);
        Model updatedModel = new Model(1, "updated_model", "updated_description", modelMapEntry, legoSet);

        when(modelDAO.findById(anyInt())).thenReturn(Optional.of(model));
        when(modelDAO.save(any(Model.class))).thenReturn(updatedModel);

        Model savedModel = modelService.update(model);
        assertNotNull(savedModel);

        verify(modelDAO, times(1)).findById(anyInt());
        verify(modelDAO, times(1)).save(any(Model.class));

    }

    @Test
    void findById() {

        Model model = new Model(1, "model", "description", modelMapEntry, legoSet);

        when(modelDAO.findById(anyInt())).thenReturn(Optional.of(model));

        Model savedModel = modelService.findById(model.getId());
        assertNotNull(savedModel);
        assertEquals(savedModel.getId(), model.getId());

        verify(modelDAO, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        Model model1 = new Model(1, "model1", "description1", modelMapEntry, legoSet);
        Model model2 = new Model(2, "model2", "description2", modelMapEntry, legoSet);

        when(modelDAO.findAll()).thenReturn(Arrays.asList(model1, model2));

        List<Model> savedModel = modelService.findAll();

        assertNotNull(savedModel);
        assertEquals(2, savedModel.size());

        verify(modelDAO, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(modelDAO).delete(any(Model.class));
        modelService.delete(new Model());
        verify(modelDAO, times(1)).delete(any(Model.class));

    }

    @Test
    void deleteById() {

        Model model = new Model(1, "model", "description", modelMapEntry, legoSet);
        doNothing().when(modelDAO).deleteById(anyInt());
        modelService.deleteById(model.getId());
        verify(modelDAO, times(1)).deleteById(anyInt());

    }

}