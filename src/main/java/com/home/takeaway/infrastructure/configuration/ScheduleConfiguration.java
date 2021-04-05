package com.home.takeaway.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class ScheduleConfiguration implements SchedulingConfigurer {

    private static final String THREAD_NAME_PREFIX = "poolScheduler";

    @Value("${server.params.schedule.poolSize}")
    private Integer schedulePoolSize;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //Allows parallel scheduler's running in thread pool
        taskRegistrar.setTaskScheduler(this.taskScheduler());
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix(THREAD_NAME_PREFIX);
        scheduler.setPoolSize(schedulePoolSize);

        return scheduler;
    }
}