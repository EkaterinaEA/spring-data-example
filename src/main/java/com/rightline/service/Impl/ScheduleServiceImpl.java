package com.rightline.service.Impl;

import com.rightline.dao.ScheduleRepository;
import com.rightline.entity.JobMerchant;
import com.rightline.entity.Schedule;
import com.rightline.service.ScheduleService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    private static Schedule schedule;

    @Override
    public Schedule save(final Schedule schedule) {
        if (schedule.getId() == null) {
            return scheduleRepository.save(schedule);
        } else {
            return scheduleRepository.save(schedule);
        }
    }

    @Override
    public Schedule getCurrentSchedule() {
        final List<Schedule> findAll = scheduleRepository.findAll();
        if (!findAll.isEmpty()) {
            return findAll.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Schedule update(final Schedule schedule) {
        if (schedule.getId() != null && findById(schedule.getId()) != null) {
            return scheduleRepository.save(schedule);
        } else {
            return null;
        }
    }

    @Override
    public Schedule findById(final Integer id) {
        final Optional<Schedule> scheduleWrapper = scheduleRepository.findById(id);
        if (scheduleWrapper.isPresent()) {
            return scheduleWrapper.get();
        } else {
            return null;
        }
    }

    @Scheduled(fixedRate = 120000)
    private void getCurrentSchedulePeriodicDataCapture() {
        schedule = getCurrentSchedule();
        System.out.println("Schedule was updated");
    }

    public void serverTasks() throws SchedulerException, ParseException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        JobDetail job = JobBuilder.newJob(JobMerchant.class).withIdentity("job1", "group1").build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule(schedule.getCron())).build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

}
