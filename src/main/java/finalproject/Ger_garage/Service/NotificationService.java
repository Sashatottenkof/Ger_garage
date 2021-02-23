package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Models.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private VerificationTokenService verificationTokenService;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * Verification email
     * @param user
     * @throws MessagingException
     */
    public void sendVerificationEmail(User user) throws MessagingException {
        VerificationToken verificationToken = verificationTokenService.findByUser(user);
        // check if the user has a tokens
        if (verificationToken!=null) {
            String token = verificationToken.getToken();
            Context context = new Context();
            context.setVariable("title", "Verify your email");
            context.setVariable("link", "https://glacial-inlet-14504.herokuapp.com/signup/activation?token="+token);
//"http://localhost:8080/
            //create HTML template and pass the variables to it
            String body = templateEngine.process("signup/Verification", context);

            //Send verification email

            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(user.getEmail());
            helper.setFrom("gersgarage@repairman.com");
            helper.setSubject("email address verification");
            helper.setText(body, true);

            javaMailSender.send(mail);

        }



    }

    /**
     * Notification email
     * @param user
     * @throws MailException
     */

    public void  sendGreeting(User user) throws MailException {
        // send email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("gersgarage@repairman.com");
        mail.setSubject("Greeting");
        mail.setText("Thank you for registering!");
        javaMailSender.send(mail);
    }
}
