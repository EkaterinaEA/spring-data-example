package com.rightline.controller;

import com.rightline.entity.Schedule;
import com.rightline.service.ScheduleService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    ResponseEntity<Schedule> save(@RequestBody final Schedule schedule) {
        final Schedule savedSchedule = scheduleService.save(schedule);
        return Optional.ofNullable(savedSchedule).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    ResponseEntity<Schedule> update(@RequestBody final Schedule schedule) {
        final Schedule updatedSchedule = scheduleService.update(schedule);
        return Optional.ofNullable(updatedSchedule).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    ResponseEntity<Schedule> serverTasks() throws ParseException, SchedulerException {
        scheduleService.serverTasks();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
