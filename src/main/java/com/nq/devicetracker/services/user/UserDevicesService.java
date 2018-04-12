package com.nq.devicetracker.services.user;

import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDevicesService {

    void updateDevices();

    List<User> getUsers();

    Device getDevice(User user, Long trackId);

    void store(Device device);

}
