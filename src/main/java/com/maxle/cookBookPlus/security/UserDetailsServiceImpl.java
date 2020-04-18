package com.maxle.cookBookPlus.security;

import com.maxle.cookBookPlus.models.entities.chefUser;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.maxle.cookBookPlus.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepo;

    public  UserDetailsServiceImpl(UserRepository r){
        this.userRepo = r;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        chefUser chefUser = userRepo.findByUsername(username);
        if (chefUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(chefUser.getUsername(), chefUser.getPassword(), Collections.emptyList());
    }



}
