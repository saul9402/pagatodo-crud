package com.pagatodo.crud.configuration.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    UserDetails isValidUser(String username, String password) {
        if (username.equalsIgnoreCase("savila") && password.equals("savila")) {
            return User.withUsername(username).password("savila").roles("USER").build();
        }
        if (username.equalsIgnoreCase("nad") && password.equals("123")) {
            return User.withUsername(username).password("123").roles("ADMIN").build();
        }
        if (username.equalsIgnoreCase("super") && password.equals("123")) {
            return User.withUsername(username).password("123").roles("USER", "ADMIN").build();
        }
        return null;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        log.info("username: {}", username);

        UserDetails userDetails = isValidUser(username, password);

        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("Incorrect user credentials.");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }

}
