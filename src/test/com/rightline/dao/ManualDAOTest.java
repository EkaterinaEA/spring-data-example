package com.rightline.dao;

import com.rightline.ApplicationRunner;
import com.rightline.entity.LegoSet;
import com.rightline.entity.Manual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(ApplicationRunner.class)
class ManualDAOTest {

    @Autowired
    LegoSetRepository legoSetRepository;

    @Autowired
    ManualDAO manualDAO;

    List<LegoSet> legoList = new ArrayList<>();
    List<Manual> manuals = new ArrayList<>();

    @BeforeEach
    void setUp(){

        LegoSet legoSet = new LegoSet("LegoSet");
        LegoSet savedLegoSet = legoSetRepository.saveAndFlush(legoSet);
        legoList.add(savedLegoSet);

        Manual manual = new Manual("Author", "text", legoSet);
        Manual savedManual = manualDAO.saveAndFlush(manual);
        manuals.add(savedManual);

    }

    @Test
    void findAllManualsByLegoSetId() {
        List<Manual> testManuals = manualDAO.findAllManualsByLegoSetId(legoList.get(0).getId());
        assertNotNull(testManuals);
        assertTrue(!testManuals.isEmpty());
        assertEquals(manuals.get(0).getAuthor(), testManuals.get(0).getAuthor());
        assertEquals(manuals.get(0).getId(), testManuals.get(0).getId());
        assertEquals(manuals.get(0).getText(), testManuals.get(0).getText());
        assertEquals(manuals.get(0).getLegoSet().getName(), testManuals.get(0).getLegoSet().getName());
    }

    @AfterEach
    void tearDown(){
        legoList.stream().forEach(legoSet -> legoSetRepository.delete(legoSet));
        manuals.stream().forEach(manual -> manualDAO.delete(manual));
    }
}