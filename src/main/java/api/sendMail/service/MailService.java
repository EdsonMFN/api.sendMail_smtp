package api.sendMail.service;

import api.sendMail.domains.entity.Mail;
import api.sendMail.domains.repository.MailRepository;
import api.sendMail.rest.request.MailRequest;
import api.sendMail.rest.response.MailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MailService {

    @Autowired
    MailRepository repository;

    @Autowired
    private JavaMailSender sender;

    public MailResponse sendEmail(MailRequest request){
        try {
            Mail mail = new Mail();
            mail.setSendDateEmail(LocalDateTime.now());
            mail.setEmailFrom(request.getEmailFrom());
            mail.setEmailTo(request.getEmailTo());
            mail.setText(request.getText());
            mail.setSubject(request.getSubject());
            mail.setOwnerRef(request.getOwnerRef());
            repository.save(mail);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(request.getEmailFrom());
            message.setTo(request.getEmailTo());
            message.setSubject(request.getSubject());
            message.setText(request.getText());
            sender.send(message);


            return new MailResponse("successs");
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
