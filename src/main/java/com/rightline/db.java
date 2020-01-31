package com.rightline;

import com.rightline.controller.LegoSetController;
import com.rightline.dao.LegoSetRepository;
import com.rightline.dao.ScheduleRepository;
import com.rightline.entity.LegoSet;
import com.rightline.entity.Manual;
import com.rightline.entity.Schedule;
import com.rightline.service.Impl.LegoSetServiceImpl;
import com.rightline.service.Impl.ScheduleServiceImpl;
import org.quartz.SchedulerException;

import java.text.ParseException;

public class db {

    public static void main(String[] args) throws ParseException, SchedulerException {
      //  ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
      //  Schedule schedule = new Schedule(1, "0 0-5 13 * * ? *");
      //  scheduleService.save(schedule);
      //  scheduleService.serverTasks();

        LegoSet legoSet = new LegoSet(1, "LegoSet");
        LegoSetServiceImpl legoSetService = new LegoSetServiceImpl();
        legoSetService.save(legoSet);

    }
}