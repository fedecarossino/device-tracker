package com.nq.devicetracker.model.device;

import com.nq.devicetracker.model.user.User;

public class Device {

    private Long id;

    private User user;

    private Status status = Status.ACTIVE;

    public Device(User user, Status status) {
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
}
