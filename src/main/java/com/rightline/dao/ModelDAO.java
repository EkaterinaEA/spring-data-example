package com.rightline.dao;

import com.rightline.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDAO extends JpaRepository<Model, Integer> {
}
