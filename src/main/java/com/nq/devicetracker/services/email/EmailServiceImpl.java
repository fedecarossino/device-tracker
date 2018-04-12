package com.nq.devicetracker.services.email;

import com.nq.devicetracker.model.email.Email;
import com.nq.devicetracker.model.email.EmailStatus;
import com.nq.devicetracker.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository emailRepository;

    public Email saveEmail(Email email){
        return emailRepository.save(email);
    }

    public void sendEmails(){
        emailRepository.findAllByStatus(EmailStatus.PENDING).stream().forEach(email-> sendEmail(email));
    }

    private void sendEmail(Email email){
        //TODO Enviar email

        email.setStatus(EmailStatus.SENT);
        emailRepository.save(email);
        System.out.println("[EmailService] Email al usuario "+email.getUserId()+ " enviado");
    }

}
