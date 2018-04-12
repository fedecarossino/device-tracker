package com.nq.devicetracker;

import com.nq.devicetracker.quartz.DevicesUpdateJob;
import com.nq.devicetracker.services.email.EmailServiceImpl;
import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.nq.devicetracker.repositories")
@EnableSpringConfigured
@ComponentScan
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
