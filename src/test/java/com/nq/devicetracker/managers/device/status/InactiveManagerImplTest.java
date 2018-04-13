package com.nq.devicetracker.managers.device.status;

import com.nq.devicetracker.model.device.Device;
import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.user.User;
import com.nq.devicetracker.services.email.EmailServiceImpl;
import com.nq.utils.DateLastConnectionsUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
public class InactiveManagerImplTest {

    @TestConfiguration
    static class DeviceWorkflowManagerImplTestContextConfiguration {

        @Bean
        public InactiveManagerImpl inactiveManager() {
            return new InactiveManagerImpl();
        }

    }

    @Autowired
    InactiveManagerImpl inactiveManager;

    @Test
    public void When_DeviceInactiveAndLastConnectionMoreThan14Days_Expect_DeviceInactive(){
        Device device = inactiveManager.manage(getInactiveDevice(), getInactiveTrackedDevice());
        Assert.assertEquals(Status.INACTIVE, device.getStatus());
    }

    @Test
    public void When_DeviceInactiveAndLastConnectionLessEqualsThan7Days_Expect_DeviceActive(){
        Device device = inactiveManager.manage(getInactiveDevice(), getActiveTrackedDevice());
        Assert.assertEquals(Status.ACTIVE, device.getStatus());
    }


    private Device getInactiveDevice(){
        return new Device(0L, new User(), Status.INACTIVE);
    }

    private TrackedDevice getActiveTrackedDevice(){
        return new TrackedDevice(1L, new Timestamp(new Date().getTime()), new User());
    }

    private TrackedDevice getInactiveTrackedDevice(){
        return new TrackedDevice(1L, DateLastConnectionsUtils.minusDaysFromNow(15), new User());
    }
}
