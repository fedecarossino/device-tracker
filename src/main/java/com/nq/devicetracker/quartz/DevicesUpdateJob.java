package com.nq.devicetracker.quartz;

import com.nq.devicetracker.services.user.UserDevicesServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class DevicesUpdateJob extends QuartzJobBean{
    @Autowired
    UserDevicesServiceImpl userDevicesServiceImpl;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        userDevicesServiceImpl.updateDevices();
    }
}
