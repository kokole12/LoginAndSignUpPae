package com.example.loginandsignuppae.Registration;

import com.example.loginandsignuppae.Registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "ap1/v1/registration")
public class RegisterPersonController {
    private final RegistrationService registrationService;
    private final ConfirmationTokenService confirmationTokenService;
    @PostMapping
    public String Register(@RequestBody RegistrationRequest registrationRequest){
           return registrationService.register(registrationRequest);
    }
//    @GetMapping
//    public String Confirm(@RequestParam("token") String token){
//        return registrationService.ConfirmToken(token);
//    }
}

