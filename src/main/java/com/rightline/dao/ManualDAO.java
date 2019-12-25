package com.rightline.dao;

import com.rightline.entity.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManualDAO extends CrudRepository<Manual, Integer>, JpaRepository<Manual, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM manuals WHERE lego_set_id = :legosetid")
    List<Manual> findAllManualsByLegoSetId (Integer legosetid);

}
