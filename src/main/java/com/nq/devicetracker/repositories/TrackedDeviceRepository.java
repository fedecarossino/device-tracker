package com.nq.devicetracker.repositories;

import com.nq.devicetracker.model.device.TrackedDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrackedDeviceRepository extends CrudRepository<TrackedDevice, Integer> {

    TrackedDevice findById(Long trackedDeviceId);
}
