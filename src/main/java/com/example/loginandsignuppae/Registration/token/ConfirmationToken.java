package com.example.loginandsignuppae.Registration.token;

import com.example.loginandsignuppae.User.AppUSer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class ConfirmationToken {

    @javax.persistence.Id
    @SequenceGenerator(
            name = "confirmationToken_sequence",
            sequenceName = "confirmationToken_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmationToken_sequence"
    )
    private Long Id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;
@ManyToOne
@JoinColumn(
        nullable = false,
        name = "app_user_Id"
)
    private AppUSer appUSer;

    public ConfirmationToken(
            String token,
            LocalDateTime createdAt,
             LocalDateTime expiresAt,
            AppUSer appUSer) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.appUSer = appUSer;
    }

}
