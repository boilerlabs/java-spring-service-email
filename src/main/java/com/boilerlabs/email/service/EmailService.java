package com.boilerlabs.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.boilerlabs.email.record.EmailRecord;

import jakarta.mail.internet.MimeMessage;

@Service
@Async
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final String fromNoreply = "noreply@boilerlabs.com";

    public void sendTemplateMail(EmailRecord emailRecord, String htmlContent) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(fromNoreply);
            helper.setTo(emailRecord.to());
            helper.setSubject(emailRecord.subject());
            helper.setText(htmlContent, true);

            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendSimpleEmail(EmailRecord emailRecord) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(fromNoreply);
            message.setTo(emailRecord.to());
            message.setSubject(emailRecord.subject());
            message.setText(emailRecord.body());

            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

}
