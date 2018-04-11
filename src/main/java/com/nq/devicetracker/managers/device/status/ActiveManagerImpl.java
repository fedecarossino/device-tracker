package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.managers.device.DeviceWorkflowManager;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.email.Email;
import com.nq.devicetracker.services.email.EmailService;
import com.nq.utils.DateLastConnectionsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActiveManagerImpl implements DeviceWorkflowManager {

    @Autowired
    EmailService emailService;

    @Override
    public Device manage(Device device, TrackedDevice trackedDevice) {
        if(DateLastConnectionsUtils.isLastConnectionMoreThan7Days(trackedDevice)) {
            device.setStatus(Status.LOST);
        }
        return device;
    }

    private void storeLostEmail(Long userId){
        Email email = new Email(userId, "We missed you", "Lost email body");
        emailService.saveEmail(email);
    }

}
