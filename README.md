# Spring Boot Email Sender

A modern, feature-rich email sending application built with Spring Boot that supports rich text editing, file attachments, and multiple email providers.

## Features

- 📧 Send emails through Gmail or Outlook
- 📝 Rich text editor for composing emails
- 📎 File attachment support
- 🖼️ Image attachment support
- 🎨 Modern, responsive UI using Bootstrap
- ✨ Real-time form validation
- 🔒 Secure email handling

## Tech Stack

- Java 17
- Spring Boot 3.1.5
- Spring Mail
- Thymeleaf
- Bootstrap 5
- Quill.js (Rich Text Editor)
- Lombok

## Prerequisites

- Java 17 or higher
- Maven
- Gmail Account with App Password or Outlook Account

## Setup & Configuration

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/EmailSender.git
   cd EmailSender
   ```

2. Configure email settings in `application.properties`:
   ```properties
   spring.mail.host=smtp.gmail.com
   spring.mail.port=587
   spring.mail.username=your-email@gmail.com
   spring.mail.password=your-app-specific-password
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true
   ```

3. For Gmail users:
   - Enable 2-factor authentication in your Google Account
   - Generate an App Password:
     1. Go to Google Account Settings
     2. Select Security
     3. Under "Signing in to Google," select 2-Step Verification
     4. At the bottom, select App passwords
     5. Generate a new app password for "Mail"
     6. Use this password in your application.properties

## Project Structure

```
src/main/java/com/LakshyaBhardwaj/EmailSender/
├── controller
│   └── EmailController.java
├── service
│   ├── EmailService.java
│   └── EmailServiceImpl.java
├── dto
│   └── EmailDTO.java
├── config
│   └── ThymeleafConfig.java
└── EmailSenderApplication.java
```

## Key Components

### EmailDTO
Data Transfer Object for email details:
```java
@Data
public class EmailDTO {
    private String to;
    private String subject;
    private String body;
    private MultipartFile[] attachments;
}
```

### EmailService
Interface defining email operations:
```java
public interface EmailService {
    void sendEmail(EmailDTO emailDTO) throws Exception;
}
```

### EmailController
Handles HTTP requests:
```java
@Controller
@RequiredArgsConstructor
public class EmailController {
    @GetMapping("/")
    public String showEmailForm(Model model) {...}
    
    @PostMapping("/send-email")
    @ResponseBody
    public ResponseEntity<String> sendEmail(@ModelAttribute EmailDTO emailDTO) {...}
}
```

## Running the Application

1. Build the project:
   ```bash
   mvn clean install
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Access the application:
   - Open your browser and navigate to `http://localhost:8080`
   - You'll see the email composition form with the rich text editor

## Using the Application

1. Enter the recipient's email address
2. Add a subject
3. Compose your message using the rich text editor
   - Format text (bold, italic, underline)
   - Add lists
   - Change text color
   - Insert images
4. Add attachments (optional)
5. Click "Send Email"

## Deployment

### Option 1: Deploy to Railway

1. Create a Railway account at [railway.app](https://railway.app)
2. Install Railway CLI:
   ```bash
   npm i -g @railway/cli
   ```

3. Login to Railway:
   ```bash
   railway login
   ```

4. Initialize Railway project:
   ```bash
   railway init
   ```

5. Add environment variables in Railway Dashboard:
   - SPRING_MAIL_HOST=smtp.gmail.com
   - SPRING_MAIL_PORT=587
   - SPRING_MAIL_USERNAME=your-email@gmail.com
   - SPRING_MAIL_PASSWORD=your-app-specific-password
   - SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH=true
   - SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE=true

6. Deploy:
   ```bash
   railway up
   ```

### Option 2: Deploy to Render

1. Create a Render account at [render.com](https://render.com)
2. Create a new Web Service
3. Connect your GitHub repository
4. Configure the service:
   - Build Command: `./mvnw clean install`
   - Start Command: `java -jar target/*.jar`
5. Add environment variables (same as Railway)
6. Click "Create Web Service"

### Option 3: Deploy using Docker

1. Build the Docker image:
   ```bash
   mvn clean package
   docker build -t emailsender .
   ```

2. Run locally:
   ```bash
   docker run -p 8080:8080 \
   -e SPRING_MAIL_HOST=smtp.gmail.com \
   -e SPRING_MAIL_PORT=587 \
   -e SPRING_MAIL_USERNAME=your-email@gmail.com \
   -e SPRING_MAIL_PASSWORD=your-app-specific-password \
   -e SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH=true \
   -e SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE=true \
   emailsender
   ```

3. Push to Docker Hub:
   ```bash
   docker tag emailsender yourusername/emailsender
   docker push yourusername/emailsender
   ```

### Important Deployment Notes

1. Always use environment variables for sensitive information
2. Enable CORS if needed for your domain
3. Configure proper security headers
4. Set up SSL/TLS for production
5. Monitor application logs and performance
6. Set up proper backup and disaster recovery
7. Configure rate limiting if needed

## Security Considerations

- Email credentials are stored in application.properties (ensure this file is not committed to version control)
- Uses App Passwords instead of actual account passwords
- Implements input validation
- Supports SMTP over TLS

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Spring Boot Team for the excellent framework
- Quill.js for the rich text editor
- Bootstrap team for the UI components
