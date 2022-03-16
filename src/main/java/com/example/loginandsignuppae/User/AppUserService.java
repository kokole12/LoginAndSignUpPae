package com.example.loginandsignuppae.User;

import com.example.loginandsignuppae.Registration.token.ConfirmationToken;
import com.example.loginandsignuppae.Registration.token.ConfirmationTokenRepository;
import com.sun.nio.sctp.IllegalReceiveException;
import lombok.AllArgsConstructor;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor

public class AppUserService implements UserDetailsService {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenRepository tokenRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email).orElseThrow(
            () -> new IllegalStateException("user not found")
    );

    }
    public String SignUp(AppUSer appUser){
        boolean UserIspresent = userRepository.findByEmail(appUser.getEmail()).isPresent();
        if(!UserIspresent){
            throw new IllegalReceiveException("user already taken");
        }
        String encoded = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encoded);

        userRepository.save(appUser);
        String token = UUID.randomUUID().toString();

        //TODO: send confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token, 
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        tokenRepository.save(confirmationToken);

        //TODO: send confirmation email
        return "";
    }
}
