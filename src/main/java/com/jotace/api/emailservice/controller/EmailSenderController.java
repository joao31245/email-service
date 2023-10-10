package com.jotace.api.emailservice.controller;

import com.amazonaws.AmazonServiceException;
import com.jotace.api.emailservice.aplication.EmailSenderService;
import com.jotace.api.emailservice.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/send")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest email) {
        try {
            this.emailSenderService.sendEmail(email.to(), email.subject(), email.body());
            return ResponseEntity.ok("Email sent successfully");
        } catch (AmazonServiceException amazonServiceException) {
            return ResponseEntity.badRequest().body("Error while sending e-mail");
        }
    }
}
