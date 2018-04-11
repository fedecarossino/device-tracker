package com.nq.devicetracker.managers.device;

import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import org.springframework.stereotype.Component;

@Component
public class DeviceWorkflowManagerImpl implements DeviceWorkflowManager{

    @Override
    public Device manage(Device currentDevice, TrackedDevice trackedDevice) {
        return currentDevice.getStatus().apply(currentDevice, trackedDevice);
    }

}
