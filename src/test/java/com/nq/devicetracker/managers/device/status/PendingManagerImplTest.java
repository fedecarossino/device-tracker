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
public class PendingManagerImplTest {

    @TestConfiguration
    static class DeviceWorkflowManagerImplTestContextConfiguration {

        @Bean
        public PendingManagerImpl pendingManager() {
            return new PendingManagerImpl();
        }

    }

    @Autowired
    PendingManagerImpl pendingManager;

    @MockBean
    private EmailServiceImpl emailService;

    @Test
    public void When_DevicePending_Expect_DeviceActive(){
        Device device = pendingManager.manage(getPendingDevice(), getActiveTrackedDevice());
        Assert.assertEquals(Status.ACTIVE, device.getStatus());
    }


    private Device getPendingDevice(){
        return new Device(new User());
    }

    private TrackedDevice getActiveTrackedDevice(){
        return new TrackedDevice(1L, new Timestamp(new Date().getTime()), new User());
    }

}
