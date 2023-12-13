package com.SpringEmailSenderApp.SpringEmailSenderApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("nawaraskc888@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		try {
			mailSender.send(message);
			System.out.println("Email sent successfully!");
		} catch (Exception e) {
			System.err.println("Error sending email: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
