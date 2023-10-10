package com.jotace.api.emailservice.aplication;

import com.jotace.api.emailservice.adapters.EmailSenderGateway;
import com.jotace.api.emailservice.core.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUserCase {


    private final EmailSenderGateway emailSenderGateway;


    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;

    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        emailSenderGateway.sendEmail(to,subject,body);
    }
}
