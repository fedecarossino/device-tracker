package com.nq.devicetracker.model.device;

import com.nq.devicetracker.managers.device.status.Status;
import com.nq.devicetracker.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "device", indexes = { @Index(name = "IDX_DEVICEID", columnList = "device_id") })
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "device_id", nullable = false)
    private Long deviceId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public Device(User user) {
        this.user = user;
    }

    public Device(Long deviceId, User user, Status status) {
        this.deviceId = deviceId;
        this.user = user;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}
