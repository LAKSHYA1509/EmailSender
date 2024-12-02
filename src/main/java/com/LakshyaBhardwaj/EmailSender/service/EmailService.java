package com.LakshyaBhardwaj.EmailSender.service;

import com.LakshyaBhardwaj.EmailSender.dto.EmailDTO;

public interface EmailService {
    void sendEmail(EmailDTO emailDTO) throws Exception;
}
