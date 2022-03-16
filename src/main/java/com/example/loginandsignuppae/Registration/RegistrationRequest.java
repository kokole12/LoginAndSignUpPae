package com.example.loginandsignuppae.Registration;

import lombok.*;

import java.security.PrivateKey;
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RegistrationRequest {
    private Long Id;
    private String firstName;
    private String LastName;
    private String email;
    private String password;

    public RegistrationRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
    }
}
