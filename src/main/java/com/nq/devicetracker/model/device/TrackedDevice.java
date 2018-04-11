package com.nq.devicetracker.model.device;

import com.nq.devicetracker.model.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tracked_device")
public class TrackedDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "device_id", nullable = false)
    private Long deviceId;

    @Column(name = "last_connection", nullable = false)
    private Timestamp lastConnection;

    @ManyToOne(fetch = FetchType.LAZY)
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
