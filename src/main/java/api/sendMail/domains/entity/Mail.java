package api.sendMail.domains.entity;


import api.sendMail.enums.StatusEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "email")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_email")
    private Long emailId;
    @Column(name = "owner_ref")
    private String ownerRef;
    @Email
    private String emailFrom;
    @Email
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column(name = "date_email")
    private LocalDateTime sendDateEmail;
    @Column(name = "status_email")
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
