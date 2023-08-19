package com.codechallenge.mailserver.service;

import com.codechallenge.mailserver.model.EmployeeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void sendEmail(EmployeeMessage employeeMessage) {
        try {
            System.out.println("Received payload: " + employeeMessage.getEmployee().getEmail());
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(employeeMessage.getEmployee().getEmail());
            message.setSubject(employeeMessage.getAction());
            message.setText("This is an automatic message");

            mailSender.send(message);
            log.info("Email sent successfully.");
        } catch (MailException ex) {
            log.info("Error sending email: " + ex.getMessage());
        } catch (Exception ex) {
            log.info("An error occurred: " + ex.getMessage());
        }
    }
}
