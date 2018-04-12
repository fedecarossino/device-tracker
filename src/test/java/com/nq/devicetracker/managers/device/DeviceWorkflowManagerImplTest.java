package com.nq.devicetracker.managers.device;


import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.managers.device.status.Status;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.user.User;
import com.nq.utils.DateLastConnectionsUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
public class DeviceWorkflowManagerImplTest {

    @TestConfiguration
    static class DeviceWorkflowManagerImplTestContextConfiguration {

        @Bean
        public DeviceWorkflowManagerImpl deviceWorkflowManagerImpl() {
            return new DeviceWorkflowManagerImpl();
        }
    }

    @Autowired
    DeviceWorkflowManagerImpl deviceWorkflowManagerImpl;

    @Test
    public void When_DevicePending_Expect_DeviceActive(){
        Device device = deviceWorkflowManagerImpl.manage(getPendingDevice(), getActiveTrackedDevice());
        Assert.assertEquals(Status.ACTIVE, device.getStatus());
    }

    @Test
    public void When_DeviceActiveAndLastConnectionLessEqualsThan7Days_Expect_DeviceActive(){
        Device device = deviceWorkflowManagerImpl.manage(getActiveDevice(), getActiveTrackedDevice());
        Assert.assertEquals(Status.ACTIVE, device.getStatus());
    }

    @Test
    public void When_DeviceActiveAndLastConnectionMoreThan7Days_Expect_DeviceLost(){
        Device device = deviceWorkflowManagerImpl.manage(getActiveDevice(), getLostTrackedDevice());
        Assert.assertEquals(Status.LOST, device.getStatus());
    }

    @Test
    public void When_DeviceLostAndLastConnectionMoreThan7Days_Expect_DeviceLost(){
        Device device = deviceWorkflowManagerImpl.manage(getLostDevice(), getLostTrackedDevice());
        Assert.assertEquals(Status.LOST, device.getStatus());
    }

    @Test
    public void When_DeviceLostAndLastConnectionLessEqualsThan7Days_Expect_DeviceActive(){
        Device device = deviceWorkflowManagerImpl.manage(getLostDevice(), getActiveTrackedDevice());
        Assert.assertEquals(Status.ACTIVE, device.getStatus());
    }

    @Test
    public void When_DeviceLostAndLastConnectionMoreThan14Days_Expect_DeviceInactive(){
        Device device = deviceWorkflowManagerImpl.manage(getLostDevice(), getInactiveTrackedDevice());
        Assert.assertEquals(Status.INACTIVE, device.getStatus());
    }

    @Test
    public void When_DeviceInactiveAndLastConnectionMoreThan14Days_Expect_DeviceInactive(){
        Device device = deviceWorkflowManagerImpl.manage(getInactiveDevice(), getInactiveTrackedDevice());
        Assert.assertEquals(Status.INACTIVE, device.getStatus());
    }

    @Test
    public void When_DeviceInactiveAndLastConnectionLessEqualsThan7Days_Expect_DeviceActive(){
        Device device = deviceWorkflowManagerImpl.manage(getInactiveDevice(), getActiveTrackedDevice());
        Assert.assertEquals(Status.ACTIVE, device.getStatus());
    }


    private Device getPendingDevice(){
        return new Device(new User());
    }

    private Device getActiveDevice(){
        return new Device(0L, new User(), Status.ACTIVE);
    }

    private Device getLostDevice(){
        return new Device(0L, new User(), Status.LOST);
    }

    private Device getInactiveDevice(){
        return new Device(0L, new User(), Status.INACTIVE);
    }

    private TrackedDevice getActiveTrackedDevice(){
        return new TrackedDevice(1L, new Timestamp(new Date().getTime()), new User());
    }

    private TrackedDevice getLostTrackedDevice(){
        return new TrackedDevice(1L, DateLastConnectionsUtils.minusDaysFromNow(8), new User());
    }

    private TrackedDevice getInactiveTrackedDevice(){
        return new TrackedDevice(1L, DateLastConnectionsUtils.minusDaysFromNow(15), new User());
    }
}
