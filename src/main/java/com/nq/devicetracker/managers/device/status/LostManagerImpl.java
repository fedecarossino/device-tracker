package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.managers.device.DeviceWorkflowManager;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.email.Email;
import com.nq.devicetracker.services.email.EmailServiceImpl;
import com.nq.utils.DateLastConnectionsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LostManagerImpl implements DeviceWorkflowManager {

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @Override
    public Device manage(Device device, TrackedDevice trackedDevice) {
        if (DateLastConnectionsUtils.isLastConnectionLessEqualsThan7Days(trackedDevice)) {
            device.setStatus(Status.ACTIVE);
        } else if (DateLastConnectionsUtils.isLastConnectionMoreThan14Days(trackedDevice)) {
            device.setStatus(Status.INACTIVE);
            storeInactiveEmail(device.getUser().getId());
        }
        return device;
    }

    private void storeInactiveEmail(Long userId){
        Email email = new Email(userId, "Inactivity", "Inactive email body");
        emailServiceImpl.saveEmail(email);
    }

}
