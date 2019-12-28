package com.rightline;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rightline.dao.LegoSetRepository;
import com.rightline.dao.ManualDAO;
import com.rightline.dao.ModelDAO;
import com.rightline.entity.LegoSet;
import com.rightline.entity.Manual;
import com.rightline.entity.Model;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(ApplicationRunner.class)
public class MyBatisTests {

    @Autowired
    LegoSetRepository repository;

    @Autowired
    ModelDAO modelDAO;

    @Autowired
    ManualDAO manualDAO;

    @Test
    public void exerciseSomewhatComplexEntity() {

        LegoSet smallCar = new LegoSet(1,"LegoSet_smallCar");

        Manual manual = new Manual(1, "Just put all the pieces together in the right order", "Jens Schauder", smallCar);
        Model model1 = new Model(1,"suv", "SUV with sliding doors.", smallCar);
        Model model2 = new Model(2,"roadster", "Slick red roadster.", smallCar);

        repository.save(smallCar);
        manualDAO.save(manual);
        modelDAO.save(model1);
        modelDAO.save(model2);

        assertThat(smallCar.getId()).isNotNull();
        assertEquals(modelDAO.findAllModelsByLegoSetId(smallCar.getId()).size(), 2);

        // not implemented
        // Output.list(repository.findAll(), "Original LegoSet");

        manualDAO.findAllManualsByLegoSetId(smallCar.getId()).get(0).setText("Just make it so it looks like a car.");

        Model model3 = new Model(3,"pickup", "A pickup truck with some tools in the back.", smallCar);
        modelDAO.save(model3);

        // Output.list(repository.findAll(), "Updated");

        Model model4 = new Model(4,"One last attempt: Just build a car! Ok?", "Jens Schauder", smallCar);
        modelDAO.save(model4);

       // Output.list(repository.findAll(), "Manual replaced");
    }

    @After
    void tearDown(){
        repository.deleteById(1);
        modelDAO.deleteById(1);
        modelDAO.deleteById(2);
        modelDAO.deleteById(3);
        modelDAO.deleteById(4);
        manualDAO.deleteById(1);
    }


}
