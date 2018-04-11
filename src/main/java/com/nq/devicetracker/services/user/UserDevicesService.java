package com.nq.devicetracker.services.user;

import com.nq.devicetracker.managers.device.DeviceWorkflowManagerImpl;
import com.nq.devicetracker.managers.device.TrackingManager;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDevicesService {

    @Autowired
    DeviceWorkflowManagerImpl deviceWorkflowManager;
    @Autowired
    TrackingManager trackingManager;

    @Transactional
    public void updateDevices() {
        for (User user : getUsers()) {
            for (TrackedDevice trackedDevice : trackingManager.getDevices(user)) {
                Device device = getDevice(user, trackedDevice.getId());
                Device modifiedDevice = deviceWorkflowManager.manage(device,
                        trackedDevice);
                store(modifiedDevice);
            }
        }
    }

    public List<User> getUsers(){
        //TODO return the users
        return new ArrayList<User>();
    }

    public Device getDevice(User user, Long trackId){
        //TODO get device for a specific deviceId
        return null;
    }

    public void store(Device device){
        //TODO save device changes
    }
}
