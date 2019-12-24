package com.krasnova.dao;

import com.krasnova.entity.ModelMapEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelMapEntryDAO extends JpaRepository<ModelMapEntry, Integer> {
}
