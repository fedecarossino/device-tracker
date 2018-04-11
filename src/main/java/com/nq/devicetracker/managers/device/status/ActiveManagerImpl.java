package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.managers.device.DeviceWorkflowManager;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.utils.DateLastConnectionsUtils;

public class ActiveManagerImpl implements DeviceWorkflowManager {

    @Override
    public Device manage(Device device, TrackedDevice trackedDevice) {
        if(DateLastConnectionsUtils.isLastConnectionMoreThan7Days(trackedDevice)) {
            device.setStatus(Status.LOST);
        }
        return device;
    }

}
