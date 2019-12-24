package com.krasnova.dao;

import com.krasnova.entity.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ManualDAO extends CrudRepository<Manual, Integer>, JpaRepository<Manual, Integer> {
}
