package api.sendMail.rest.response;

import api.sendMail.domains.model.MailDto;
import lombok.Data;

@Data
public class MailResponse {
    private MailDto mailDto;

    private String msg;

    public MailResponse(MailDto mailDto) {
        this.mailDto = mailDto;
    }

    public MailResponse(String msg) {
        this.msg = msg;
    }
}
