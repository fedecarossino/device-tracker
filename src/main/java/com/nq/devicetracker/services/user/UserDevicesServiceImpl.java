package com.nq.devicetracker.services.user;

import com.nq.devicetracker.managers.device.DeviceWorkflowManagerImpl;
import com.nq.devicetracker.managers.device.TrackingManagerImpl;
import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.user.User;
import com.nq.devicetracker.repositories.DeviceRepository;
import com.nq.devicetracker.repositories.TrackedDeviceRepository;
import com.nq.devicetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDevicesServiceImpl implements UserDevicesService{

    @Autowired
    DeviceWorkflowManagerImpl deviceWorkflowManager;
    @Autowired
    TrackingManagerImpl trackingManagerImpl;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    TrackedDeviceRepository trackedDeviceRepository;

    @Transactional
    public void updateDevices() {
        for (User user : getUsers()) {
            for (TrackedDevice trackedDevice : trackingManagerImpl.getDevices(user)) {
                Device device = getDevice(user, trackedDevice.getId());
                Device modifiedDevice = deviceWorkflowManager.manage(device,
                        trackedDevice);
                store(modifiedDevice);
            }
        }
    }

    public List<User> getUsers(){
        //TODO improve better solution for huge amount of users
        return userRepository.findAll();
    }

    /**
     *
     * @param user
     * @param trackId
     * @return the device by deviceId from the tracking or a new device object with the tracking information
     *
     */
    public Device getDevice(User user, Long trackId){
        Long deviceId;
        Device device;

        TrackedDevice trackedDevice = trackedDeviceRepository.findById(trackId);

        deviceId = trackedDevice.getDeviceId();

        device = deviceRepository.findByDeviceId(deviceId);

        if(device == null){
            return new Device(deviceId, user);
        }

        return device;
    }

    @Transactional
    public void store(Device device){
        deviceRepository.save(device);
    }


}
