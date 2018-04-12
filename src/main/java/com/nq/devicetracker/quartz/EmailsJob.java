package com.nq.devicetracker.quartz;

import com.nq.devicetracker.services.email.EmailServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class EmailsJob extends QuartzJobBean {

    @Autowired
    EmailServiceImpl emailService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        emailService.sendEmails();
    }
}
