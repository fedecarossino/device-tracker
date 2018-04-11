package com.nq.devicetracker.services.email;

import com.nq.devicetracker.model.email.Email;
import com.nq.devicetracker.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    public Email saveEmail(Email email){
        return emailRepository.save(email);
    }

}
