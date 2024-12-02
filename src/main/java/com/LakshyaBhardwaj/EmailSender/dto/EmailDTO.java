package com.LakshyaBhardwaj.EmailSender.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EmailDTO {
    private String to;
    private String subject;
    private String body;
    private MultipartFile[] attachments;
}
