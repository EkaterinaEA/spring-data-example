package com.rightline.service;

import com.rightline.ApplicationRunner;
import com.rightline.dao.LegoSetRepository;
import com.rightline.entity.LegoSet;
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
class LegoSetServiceTest {

    @MockBean
    LegoSetRepository legoSetRepository;

    @Autowired
    LegoSetService legoSetService;

    @Test
    void save() {

        LegoSet legoSet = new LegoSet("LegoSet1");
        LegoSet storedLegoSet = new LegoSet(1,"LegoSet1");

        when(legoSetRepository.save(any(LegoSet.class))).thenReturn(storedLegoSet);

        LegoSet savedLegoSet = legoSetService.save(legoSet);
        assertNotNull(savedLegoSet);

        verify(legoSetRepository, times(1)).save(any(LegoSet.class));

    }

    @Test
    void update() {

        LegoSet legoSet = new LegoSet(1, "LegoSet");
        LegoSet updatedLegoSet = new LegoSet(1, "update_LegoSet");

        when(legoSetRepository.findById(anyInt())).thenReturn(Optional.of(legoSet));
        when(legoSetRepository.save(any(LegoSet.class))).thenReturn(updatedLegoSet);

        LegoSet savedLegoSet = legoSetService.update(legoSet);
        assertNotNull(savedLegoSet);

        verify(legoSetRepository, times(1)).findById(anyInt());
        verify(legoSetRepository, times(1)).save(any(LegoSet.class));

    }

    @Test
    void findById() {

        LegoSet legoSet = new LegoSet(1, "LegoSet");

        when(legoSetRepository.findById(anyInt())).thenReturn(Optional.of(legoSet));

        LegoSet savedLegoSet = legoSetService.findById(legoSet.getId());
        assertNotNull(savedLegoSet);
        assertEquals(savedLegoSet.getId(), legoSet.getId());

        verify(legoSetRepository, times(1)).findById(anyInt());

    }

    @Test
    void findAll() {

        LegoSet legoSet1 = new LegoSet(1,"LegoSet1");
        LegoSet legoSet2 = new LegoSet( 2,"LegoSet2");

        when(legoSetRepository.findAll()).thenReturn(Arrays.asList(legoSet1, legoSet2));

        List<LegoSet> savedLegoSet = legoSetService.findAll();

        assertNotNull(savedLegoSet);
        assertEquals(2, savedLegoSet.size());

        verify(legoSetRepository, times(1)).findAll();

    }

    @Test
    void delete() {

        doNothing().when(legoSetRepository).delete(any(LegoSet.class));
        legoSetService.delete(new LegoSet());
        verify(legoSetRepository, times(1)).delete(any(LegoSet.class));

    }

    @Test
    void deleteById() {

        LegoSet legoSet = new LegoSet(1, "LegoSet");
        doNothing().when(legoSetRepository).deleteById(anyInt());
        legoSetService.deleteById(legoSet.getId());
        verify(legoSetRepository, times(1)).deleteById(anyInt());

    }
}