package com.desapex.spacemanager.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendInvitation(String recipient, String subject, String message, LocalDateTime startDateTime, LocalDateTime endDateTime) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(message, true);

        // create and attach .ics file
        String icsFileContent = createICSFileContent(subject, startDateTime, endDateTime);
        InputStreamSource attachmentSource = new ByteArrayResource(icsFileContent.getBytes(StandardCharsets.UTF_8));
        helper.addAttachment("invite.ics", attachmentSource, "text/calendar");

        javaMailSender.send(mimeMessage);
    }

    private String createICSFileContent(String subject, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        StringBuilder sb = new StringBuilder();

        // create .ics file content
        sb.append("BEGIN:VCALENDAR\n");
        sb.append("VERSION:2.0\n");
        sb.append("PRODID:-//Desapex//NONSGML Event//EN\n");
        sb.append("BEGIN:VEVENT\n");
        sb.append("UID:").append(UUID.randomUUID()).append("\n");
        sb.append("DTSTAMP:").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'"))).append("\n");
        sb.append("DTSTART:").append(startDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'"))).append("\n");
        sb.append("DTEND:").append(endDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'"))).append("\n");
        sb.append("SUMMARY:").append(subject).append("\n");
        sb.append("END:VEVENT\n");
        sb.append("END:VCALENDAR\n");

        return sb.toString();
    }
}