/*package com.rightline.entity;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class JobSchedule implements Job {

    private static Schedule schedule = new Schedule("0 0/1 * * * ?");

    public static Schedule getSchedule() {
        return schedule;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // здесь забрать данные из базы данных, присвоить schedule новое значение
        schedule = new Schedule("0 0/2 * * * ?");
        System.out.println("Schedule was updated");
    }

}

 */