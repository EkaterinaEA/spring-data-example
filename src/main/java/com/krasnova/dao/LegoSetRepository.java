package com.krasnova.dao;

import com.krasnova.entity.LegoSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LegoSetRepository extends CrudRepository<LegoSet, Integer>, JpaRepository<LegoSet, Integer> {
}
