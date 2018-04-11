package com.nq.devicetracker.repositories;

import com.nq.devicetracker.model.email.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmailRepository extends JpaRepository<Email, Integer> {

    @Transactional
    Email save(Email email);
}
