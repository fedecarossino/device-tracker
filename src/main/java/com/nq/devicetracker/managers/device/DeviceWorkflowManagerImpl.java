package com.nq.devicetracker.managers.device;

import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DeviceWorkflowManagerImpl implements DeviceWorkflowManager{

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Device manage(Device currentDevice, TrackedDevice trackedDevice) {

        DeviceWorkflowManager deviceWorkflowManagerBean = (DeviceWorkflowManager) applicationContext.getBean(currentDevice.getStatus().getBeanName());

        return deviceWorkflowManagerBean.manage(currentDevice, trackedDevice);
    }

}
