package com.restapi.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private final JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String messagebody) {
        System.out.println(toEmail);
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println(subject);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(messagebody);
        message.setFrom("ranjith45672001@gmail.com");
        javaMailSender.send(message);

    }

    public void sendEmailWithAttachment(String toEmail, String subject, String messagebody, byte[] pdfBytes, String filename) throws IOException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(messagebody);

        // Attach the PDF file
        ByteArrayResource byteArrayResource = new ByteArrayResource(pdfBytes);
        helper.addAttachment(filename,byteArrayResource);

        javaMailSender.send(message);
    }
}
