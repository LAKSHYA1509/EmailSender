package com.LakshyaBhardwaj.EmailSender.controller;

import com.LakshyaBhardwaj.EmailSender.dto.EmailDTO;
import com.LakshyaBhardwaj.EmailSender.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/")
    public String showEmailForm(Model model) {
        model.addAttribute("emailDTO", new EmailDTO());
        return "/email_form";  
    }

    @PostMapping("/send-email")
    @ResponseBody
    public ResponseEntity<String> sendEmail(@ModelAttribute EmailDTO emailDTO) {
        try {
            emailService.sendEmail(emailDTO);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to send email: " + e.getMessage());
        }
    }
}
