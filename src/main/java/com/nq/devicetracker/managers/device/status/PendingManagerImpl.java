package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.managers.device.DeviceWorkflowManager;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.email.Email;
import com.nq.devicetracker.services.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PendingManagerImpl implements DeviceWorkflowManager{

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @Override
    public Device manage(Device device, TrackedDevice trackedDevice) {
        device.setStatus(Status.ACTIVE);
        return device;
    }

    private void storeWelcomeEmail(Long userId){
        Email email = new Email(userId, "Welcome", "welcome email body");
        emailServiceImpl.saveEmail(email);
    }
}
