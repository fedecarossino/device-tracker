package com.nq.devicetracker.managers.device;

import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrackingManager {

    public List<TrackedDevice> getDevices(User user) {
        return null; //TODO return devices for a specific user
    }
}
