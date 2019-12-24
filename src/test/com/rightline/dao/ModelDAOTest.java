package com.rightline.dao;

import com.rightline.ApplicationRunner;
import com.rightline.entity.LegoSet;
import com.rightline.entity.Model;
import com.rightline.entity.ModelMapEntry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(ApplicationRunner.class)
class ModelDAOTest {

    @Autowired
    ModelDAO modelDAO;

    @Autowired
    ModelMapEntryDAO modelMapEntryDAO;

    @Autowired
    LegoSetRepository legoSetRepository;

    List<Model> models = new ArrayList<>();
    List<ModelMapEntry> modelMaps = new ArrayList<>();
    List<LegoSet> legoSets = new ArrayList<>();

    @BeforeEach
    void setUp(){

        ModelMapEntry modelMapEntry = new ModelMapEntry(1, "key");
        ModelMapEntry savedModelMapEntry = modelMapEntryDAO.saveAndFlush(modelMapEntry);
        modelMaps.add(savedModelMapEntry);

        LegoSet legoSet = new LegoSet(1, "LegoSet");
        LegoSet savedLegoSet = legoSetRepository.saveAndFlush(legoSet);
        legoSets.add(savedLegoSet);

        Model model = new Model(1, "name", "description", savedModelMapEntry, savedLegoSet);
        Model savedModel = modelDAO.saveAndFlush(model);
        models.add(savedModel);

    }

    @AfterEach
    void tearDown(){
        modelMaps.stream().forEach(modelMapEntry -> modelMapEntryDAO.delete(modelMapEntry));
        legoSets.stream().forEach(legoSet -> legoSetRepository.delete(legoSet));
        models.stream().forEach(model -> modelDAO.delete(model));
    }

    @Test
    void findAllModelsByLegoSetId() {
        List<Model> testModels = modelDAO.findAllModelsByLegoSetId(legoSets.get(0).getId());
        assertNotNull(testModels);
        assertTrue(!testModels.isEmpty());
        assertEquals(testModels.get(0).getId(), testModels.get(0).getId());
        assertEquals(testModels.get(0).getDescription(), testModels.get(0).getDescription());
        assertEquals(testModels.get(0).getName(), testModels.get(0).getName());
        assertEquals(testModels.get(0).getLegoSet().getId(), testModels.get(0).getLegoSet().getId());
        assertEquals(testModels.get(0).getModelMapEntry().getId(), testModels.get(0).getModelMapEntry().getId());
    }
}