package com.nq.devicetracker.repositories;

import com.nq.devicetracker.model.email.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmailRepository extends CrudRepository<Email, Integer> {

    @Transactional
    Email save(Email email);
}
