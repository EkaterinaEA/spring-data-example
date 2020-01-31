package com.rightline.dao;

import com.rightline.entity.ModelMapEntry;
import com.rightline.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
