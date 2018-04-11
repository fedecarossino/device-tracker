package com.nq.devicetracker.model.user;

import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;

    private Set<Device> devices = new HashSet<>();

    private Set<TrackedDevice> trackedDevices = new HashSet<>();

    public User(Set<Device> devices, Set<TrackedDevice> trackedDevices) {
        this.devices = devices;
        this.trackedDevices = trackedDevices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public Set<TrackedDevice> getTrackedDevices() {
        return trackedDevices;
    }

    public void setTrackedDevices(Set<TrackedDevice> trackedDevices) {
        this.trackedDevices = trackedDevices;
    }

}
