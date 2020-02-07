package com.rightline.service;

import com.rightline.entity.Schedule;

import java.text.ParseException;
import java.util.List;

public interface ScheduleService {

    Schedule save(Schedule schedule);

    Schedule update(Schedule schedule);

    Schedule findById(Integer id);

    Schedule getSchedule();

    List<Schedule> findAll();

 //   void startMerchantAction() throws SchedulerException, ParseException;
}
