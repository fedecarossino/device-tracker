package com.nq.devicetracker.repositories;

import com.nq.devicetracker.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();
}
