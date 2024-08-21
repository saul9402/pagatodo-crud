package com.pagatodo.crud.configuration.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("savila".equalsIgnoreCase(username)) {
            return User.withUsername(username).password("$2a$10$BcJ74J.SyKR2lqMadXWirO4nx7/rI2hzFbdI5Hfm79unYMmMaYCjK").roles("USER").build();//savila
        }
        if ("spamer".equalsIgnoreCase(username)) {
            return User.withUsername(username).password("$2a$10$XG8fbveK2axLbwUI1yQ.W.CVFsid7pNhPXFAqjYJom9A1QV/wSzRm").roles("ADMIN").build();//123
        }
        if ("admin".equalsIgnoreCase(username)) {
            return User.withUsername(username).password("$2a$10$LlZlTRgTzoZ5NFpKZABna.bxOj/rP3qy480exXn38ZaUCAq4R3ZPe").roles("USER", "ADMIN").build();//456
        }
        throw new BadCredentialsException("No existe el usuario");
    }

}
