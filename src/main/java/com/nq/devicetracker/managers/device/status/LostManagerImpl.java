package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.managers.device.DeviceWorkflowManager;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.utils.DateLastConnectionsUtils;

public class LostManagerImpl implements DeviceWorkflowManager{

    @Override
    public Device manage(Device device, TrackedDevice trackedDevice) {
        if (DateLastConnectionsUtils.isLastConnectionLessEqualsThan7Days(trackedDevice)) {
            device.setStatus(Status.ACTIVE);
        } else if (DateLastConnectionsUtils.isLastConnectionMoreThan14Days(trackedDevice)) {
            device.setStatus(Status.INACTIVE);
        }
        return device;
    }

}
