package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.managers.device.DeviceWorkflowManager;
import com.nq.devicetracker.managers.device.status.ActiveManagerImpl;
import com.nq.devicetracker.managers.device.status.InactiveManagerImpl;
import com.nq.devicetracker.managers.device.status.LostManagerImpl;
import com.nq.devicetracker.managers.device.status.PendingManagerImpl;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;

public enum Status {

    PENDING(new PendingManagerImpl()),
    ACTIVE(new ActiveManagerImpl()),
    LOST(new LostManagerImpl()),
    INACTIVE(new InactiveManagerImpl());

    private DeviceWorkflowManager status;

    Status(DeviceWorkflowManager status) {
        this.status = status;
    }

    public Device apply(Device currentDevice, TrackedDevice trackedDevice){
        return this.status.manage(currentDevice, trackedDevice);
    }
}
