package com.rightline.entity;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

public class CustomDynamicSchedule implements DynamicSchedule, Trigger {

    private TaskScheduler taskScheduler;
    private ScheduledFuture<?> schedulerFuture; // планировщик будущего

    /**
     * milliseconds
     */
    private long delayInterval; // Интервал задержки

    public CustomDynamicSchedule(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    // Increases delay period - Увеличивает период задержки
    @Override
    public void increaseDelayInterval(Long delay) {
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval += delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }

    @Override
    public void decreaseDelayInterval(Long delay) {
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval -= delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }

    @Override
    public void delay(Long delay) {
        if (schedulerFuture != null) {
            schedulerFuture.cancel(true);
        }
        this.delayInterval = delay;
        schedulerFuture = taskScheduler.schedule(() -> { }, this);
    }

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        Date lastTime = triggerContext.lastActualExecutionTime();
        // заменить эту строку
        return (lastTime == null) ? new Date() : new Date(lastTime.getTime() + delayInterval);
    }
}