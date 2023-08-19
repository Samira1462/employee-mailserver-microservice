package com.codechallenge.mailserver.service;

import com.codechallenge.mailserver.model.Employee;
import com.codechallenge.mailserver.model.EmployeeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.*;


class EmailServiceTest {

private EmailService emailService;

    @Mock
    private JavaMailSender mockMailSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        emailService = new EmailService(mockMailSender);
    }

    @Test
    @DisplayName("send email successful")
    public void sendEmailSuccess() {
        UUID employeeId = UUID.fromString("39822545-e35d-4445-80a5-64336b59f166");
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setFirstName("Samira");
        employee.setLastName("Radmaneshfar");
        employee.setEmail("Samira.Radmaneshfar@gamil.com");
        Date birthdayDate = new Date(1661617210633L);
        employee.setBirthday(birthdayDate);
        EmployeeMessage employeeMessage = new EmployeeMessage("Action", employee);

        doNothing().when(mockMailSender).send(any(SimpleMailMessage.class));

        emailService.sendEmail(employeeMessage);

        verify(mockMailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("send email return exception")
    void sendEmailThenReturnMailException() {
        UUID employeeId = UUID.fromString("39822545-e35d-4445-80a5-64336b59f166");
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setFirstName("Samira");
        employee.setLastName("Radmaneshfar");
        employee.setEmail("Samira.Radmaneshfar@gamil.com");
        Date birthdayDate = new Date(1661617210633L);
        employee.setBirthday(birthdayDate);
        EmployeeMessage employeeMessage = new EmployeeMessage("Action", employee);

        doThrow(new MailException("Mail send failed.") {}).when(mockMailSender).send(any(SimpleMailMessage.class));

        emailService.sendEmail(employeeMessage);

        verify(mockMailSender, times(1)).send(any(SimpleMailMessage.class));

    }

    @Test
    @DisplayName("get employee return exception")
    public void sendEmailThenReturnGenericException() {

        UUID employeeId = UUID.fromString("39822545-e35d-4445-80a5-64336b59f166");
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setFirstName("Samira");
        employee.setLastName("Radmaneshfar");
        employee.setEmail("Samira.Radmaneshfar@gamil.com");
        Date birthdayDate = new Date(1661617210633L);
        employee.setBirthday(birthdayDate);
        EmployeeMessage employeeMessage = new EmployeeMessage("Action", employee);


        doThrow(new RuntimeException("Some unexpected error"))
                .when(mockMailSender)
                .send(any(SimpleMailMessage.class));

        emailService.sendEmail(employeeMessage);

        verify(mockMailSender, times(1)).send(any(SimpleMailMessage.class));
    }

}
