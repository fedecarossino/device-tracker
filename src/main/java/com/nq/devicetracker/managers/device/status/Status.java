package com.nq.devicetracker.managers.device.status;

public enum Status {

    PENDING("pendingManagerImpl"),
    ACTIVE("activeManagerImpl"),
    LOST("lostManagerImpl"),
    INACTIVE("inactiveManagerImpl");

    private String beanName;

    Status(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName(){
        return this.beanName;
    }

}
