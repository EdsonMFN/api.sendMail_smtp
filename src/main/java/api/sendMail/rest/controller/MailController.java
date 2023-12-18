package api.sendMail.rest.controller;

import api.sendMail.rest.request.MailRequest;
import api.sendMail.rest.response.MailResponse;
import api.sendMail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private MailService service;

    @PostMapping( consumes = {"application/json"})
    public ResponseEntity<MailResponse> sendEmail(@RequestBody MailRequest request){
        MailResponse response = service.sendEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
