package com.example.SpringEmail;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
//		emailSenderService.sendEmail("MailWhomToSend", "Test Email", "This is a test email");

		emailSenderService.sendWithAttachment("MailWhomToSend",
				"Test Email",
				"This is a test email",
				"/home/hari/Downloads/anime.gif");

	}
}