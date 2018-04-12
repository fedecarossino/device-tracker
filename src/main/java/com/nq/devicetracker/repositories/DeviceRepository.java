package com.nq.devicetracker.repositories;

import com.nq.devicetracker.model.device.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Integer> {

    Device findByDeviceId(Long deviceId);

    @Transactional
    Device save(Device item);

    boolean existsById(Long id);
}
