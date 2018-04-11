package com.nq.devicetracker.model.user;

import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Device> devices = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<TrackedDevice> trackedDevices = new HashSet<>();

    public User(Set<Device> devices, Set<TrackedDevice> trackedDevices) {
        this.devices = devices;
        this.trackedDevices = trackedDevices;
    }

    public User() {
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
