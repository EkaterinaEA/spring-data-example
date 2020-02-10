package com.rightline.springquartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.StringJoiner;

public class ExecutorJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        StringJoiner stringJoiner = new StringJoiner("\n", "", "\n");
        stringJoiner.add("**************************");
        stringJoiner.add("Job: " + context.getJobDetail().getKey().getName());
        stringJoiner.add("Triger: " + context.getTrigger().getKey().getName());
       // if (context.getPreviousFireTime() != null) {
        stringJoiner.add("previous fire time: " + context.getPreviousFireTime().getTime());
        stringJoiner.add("next fire time: " + context.getNextFireTime().getTime());
        stringJoiner.add("**************************");
        System.out.println(stringJoiner.toString());

    }
}