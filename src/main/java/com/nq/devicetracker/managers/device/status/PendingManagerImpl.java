package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.managers.device.DeviceWorkflowManager;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;

public class PendingManagerImpl implements DeviceWorkflowManager{

    @Override
    public Device manage(Device device, TrackedDevice trackedDevice) {
        device.setStatus(Status.ACTIVE);
        return device;
    }
}
