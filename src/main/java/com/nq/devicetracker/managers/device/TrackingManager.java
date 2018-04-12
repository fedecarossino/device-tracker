package com.nq.devicetracker.managers.device;

import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackingManager {

    List<TrackedDevice> getDevices(User user);
}
