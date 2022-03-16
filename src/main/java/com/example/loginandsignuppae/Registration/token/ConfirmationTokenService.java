package com.example.loginandsignuppae.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository tokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        tokenRepository.save(token);
    }
    public String getToken(String token){
        return token;
    }
}
