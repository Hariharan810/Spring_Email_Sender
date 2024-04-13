package com.example.SpringEmail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text) {
        // Create a simple email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yourMail");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        // Send the email
        javaMailSender.send(message);
        System.out.println("Email sent successfully");
    }

    public void sendWithAttachment(String to, String subject, String text, String attachment) throws MessagingException  {
        // Create a simple email message
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("yourMail");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file = new FileSystemResource(new File(attachment));

        helper.addAttachment(file.getFilename(), file);

        javaMailSender.send(message);
        System.out.println("Email sent successfully");

    }
}
