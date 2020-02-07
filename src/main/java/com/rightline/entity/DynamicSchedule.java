package com.rightline.entity;

public interface DynamicSchedule {
    /**
     * Delays config - Планировщик задержек
     * @param milliseconds - the time to delay config. - время задержки планировщика.
     */
    abstract void delay(Long milliseconds);

    /**
     * Decreases delay period - Уменьшает период задержки
     * @param milliseconds - the time to decrease delay period. - время уменьшения периода задержки.
     */
    abstract void decreaseDelayInterval(Long milliseconds);

    /**
     * Increases delay period - Увеличивает период задержки
     * @param milliseconds - the time to increase dela period
     */
    abstract void increaseDelayInterval(Long milliseconds);
}
