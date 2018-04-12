package com.nq.devicetracker.managers.device;

import com.nq.devicetracker.model.device.TrackedDevice;
import com.nq.devicetracker.model.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Component
public class TrackingManagerImpl implements TrackingManager{

    @PersistenceContext
    private EntityManager em;

    public List<TrackedDevice> getDevices(User user) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<TrackedDevice> query = builder.createQuery(TrackedDevice.class);
        Root<TrackedDevice> root = query.from(TrackedDevice.class);

        Expression<Long> groupByExp = root.get("deviceId").as(Long.class);
        Expression<Long> maxLastConnection = builder.max(groupByExp);

        query.select(root);
        query.where(builder.equal(root.get("user"), user));
        query.groupBy(groupByExp);

        List<TrackedDevice> TrackedDeviceList = em.createQuery(query).getResultList();

        return TrackedDeviceList;
    }
}
