package com.dubin.football.service.util;

import com.dubin.football.database.model.Visitor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsConverter implements Converter<Visitor, UserDetails> {

    @Override
    public UserDetails convert(Visitor visitor) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(visitor.getName())
                .password(visitor.getPassword())
                .authorities(visitor.getRole().name())
                .build();
    }
}
