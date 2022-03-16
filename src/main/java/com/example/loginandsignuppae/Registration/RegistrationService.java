package com.example.loginandsignuppae.Registration;

import com.example.loginandsignuppae.Registration.token.ConfirmationToken;
import com.example.loginandsignuppae.Registration.token.ConfirmationTokenService;
import com.example.loginandsignuppae.User.AppUSer;
import com.example.loginandsignuppae.User.AppUSerRoles;
import com.example.loginandsignuppae.User.AppUserService;
import com.sun.nio.sctp.IllegalReceiveException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest registrationRequest) {
       boolean IsValid =  emailValidator.test(registrationRequest.getEmail());
       if(!IsValid){
           throw new IllegalReceiveException("email not valid");
       }
    return appUserService.SignUp(
            new AppUSer(
                    registrationRequest.getFirstName(),
                    registrationRequest.getLastName(),
                    registrationRequest.getEmail(),
                    registrationRequest.getPassword(),
                    AppUSerRoles.ADMIN
            )
    );
    }
//    public String ConfirmToken(String token){
//        ConfirmationToken confirmationToken = confirmationTokenService
//                .getToken(token)
//                .
//
//
//    }
}
