package com.nq.devicetracker;

import com.nq.devicetracker.quartz.DevicesUpdateJob;
import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevicetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevicetrackerApplication.class, args);
	}

	@Bean
	public JobDetail devicesUpdateJobDetail() {
		return JobBuilder.newJob(DevicesUpdateJob.class).withIdentity("DevicesUpdateJob").storeDurably().build();
	}

	@Bean
	public Trigger devicesUpdateJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(10).repeatForever();

		return TriggerBuilder.newTrigger().forJob(devicesUpdateJobDetail())
				.withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
	}
}
