package com.rightline.service.Impl;

import com.rightline.dao.ScheduleRepository;
import com.rightline.entity.Schedule;
import com.rightline.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule save(final Schedule schedule) {
        if (schedule.getId() == null) {
            return scheduleRepository.save(schedule);
        } else {
            return scheduleRepository.save(schedule);
        }
    }

    @Override
    public Schedule getSchedule() {
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

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    /*
    public void getCurrentSchedule() throws SchedulerException, ParseException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler config = factory.getScheduler();
        JobDetail job = JobBuilder.newJob(JobSchedule.class).withIdentity("job1", "group1").build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")).build();
        config.scheduleJob(job, trigger);
        config.start();
    }

    public void startMerchantAction() throws SchedulerException, ParseException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler config = factory.getScheduler();
        JobDetail job = JobBuilder.newJob(JobMerchant.class).withIdentity("job2", "group2").build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule(JobSchedule.getSchedule().getCron())).build();
        config.scheduleJob(job, trigger);
        config.start();
    }

     */

}
