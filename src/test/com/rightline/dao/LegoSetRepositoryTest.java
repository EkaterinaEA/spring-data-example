package com.rightline.dao;

import com.rightline.entity.LegoSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.rightline.ApplicationRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(ApplicationRunner.class)
class LegoSetRepositoryTest {

    @Autowired
    LegoSetRepository legoSetRepository;

    List<LegoSet> legoSets = new ArrayList<>();

    @BeforeEach
    void setUp(){

        LegoSet legoSet = new LegoSet("LegoSet1");
        LegoSet savedLegoSet = legoSetRepository.saveAndFlush(legoSet);
        legoSets.add(savedLegoSet);
    }

    @AfterEach
    void tearDown(){
        legoSets.stream().forEach(legoSet -> legoSetRepository.delete(legoSet));
    }

}