package com.nq.devicetracker.managers.device;

import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import org.springframework.stereotype.Service;

@Service
public interface DeviceWorkflowManager {

    Device manage(Device currentDevice, TrackedDevice trackedDevice);

}
