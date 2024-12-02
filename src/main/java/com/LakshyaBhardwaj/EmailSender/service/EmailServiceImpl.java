package com.LakshyaBhardwaj.EmailSender.service;

import com.LakshyaBhardwaj.EmailSender.dto.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(EmailDTO emailDTO) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(emailDTO.getTo());
        helper.setSubject(emailDTO.getSubject());
        helper.setText(emailDTO.getBody(), true); // true indicates HTML content

        if (emailDTO.getAttachments() != null) {
            for (MultipartFile file : emailDTO.getAttachments()) {
                helper.addAttachment(
                    file.getOriginalFilename(),
                    new ByteArrayResource(file.getBytes())
                );
            }
        }

        javaMailSender.send(message);
    }
}
