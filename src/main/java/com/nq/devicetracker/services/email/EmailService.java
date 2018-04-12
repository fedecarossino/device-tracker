package com.nq.devicetracker.services.email;

import com.nq.devicetracker.model.email.Email;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    Email saveEmail(Email email);

}
