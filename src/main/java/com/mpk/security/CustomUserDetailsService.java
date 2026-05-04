package com.mpk.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.mpk.model.User;
import com.mpk.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

//    @Override
//    public UserDetails loadUserByUsername(String email) {
//        User user = repo.findByEmail(email).orElseThrow();
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                new ArrayList<>()
//        );
//    }
    @Override
    public UserDetails loadUserByUsername(String email) {

        User user = repo.findByEmail(email).orElseThrow();

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())   // 🔥 IMPORTANT
                .build();
    }
}