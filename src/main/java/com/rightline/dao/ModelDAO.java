package com.rightline.dao;

import com.rightline.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelDAO extends JpaRepository<Model, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM models WHERE lego_set_id = :legosetid")
    List<Model> findAllModelsByLegoSetId(final Integer legosetid);

}
