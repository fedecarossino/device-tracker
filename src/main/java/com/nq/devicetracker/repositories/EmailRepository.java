package com.nq.devicetracker.repositories;

import com.nq.devicetracker.model.email.Email;
import com.nq.devicetracker.model.email.EmailStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmailRepository extends CrudRepository<Email, Integer> {

    List<Email> findAllByStatus(EmailStatus status);

    @Transactional
    Email save(Email email);
}
