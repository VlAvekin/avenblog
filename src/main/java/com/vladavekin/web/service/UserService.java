package com.vladavekin.web.service;

import com.vladavekin.web.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepo.findByUserName(userName);
    }
}
