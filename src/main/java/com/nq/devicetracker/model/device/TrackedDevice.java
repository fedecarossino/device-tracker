package com.nq.devicetracker.model.device;

import com.nq.devicetracker.model.user.User;

import java.sql.Timestamp;

public class TrackedDevice {

    private Long id;

    private Long deviceId;

    private Timestamp lastConnection;

    private User user;

    public TrackedDevice(Long deviceId, Timestamp lastConnection, User user) {
        this.deviceId = deviceId;
        this.lastConnection = lastConnection;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Timestamp getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(Timestamp lastConnection) {
        this.lastConnection = lastConnection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
