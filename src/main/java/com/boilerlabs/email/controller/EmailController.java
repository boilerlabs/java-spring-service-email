package com.boilerlabs.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.boilerlabs.email.record.EmailRecord;
import com.boilerlabs.email.record.EmailRequestRecord;
import com.boilerlabs.email.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @PostMapping("/send")
    public void sendEmail(
            @RequestBody EmailRecord emailRecord) {
        emailService.sendSimpleEmail(emailRecord);
    }

    @PostMapping("/send-template")
    public void sendWelcomeEmail(
            @RequestBody EmailRequestRecord emailRequestRecord) {
        String emailSubject = "Welcome to Boilerlabs!";
        EmailRecord emailRecord = new EmailRecord(emailRequestRecord.email(), emailSubject, "");

        Context context = new Context();
        context.setVariable("username", emailRequestRecord.username());
        context.setVariable("gettingStartedLink", "your_link_here");
        context.setVariable("communityLink", "your_link_here");
        context.setVariable("supportLink", "your_link_here");

        String htmlContent = templateEngine.process("welcome-email", context);
        emailService.sendTemplateMail(emailRecord, htmlContent);
    }

}
