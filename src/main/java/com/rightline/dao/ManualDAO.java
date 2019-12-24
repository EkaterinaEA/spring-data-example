package com.rightline.dao;

import com.rightline.entity.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ManualDAO extends CrudRepository<Manual, Integer>, JpaRepository<Manual, Integer> {
}
