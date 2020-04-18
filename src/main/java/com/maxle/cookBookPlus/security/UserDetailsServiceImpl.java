package com.maxle.cookBookPlus.security;

// ! Importing User from UserDetails, not the User entity
import com.maxle.cookBookPlus.models.entities.chefUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.maxle.cookBookPlus.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepo;

    public  UserDetailsServiceImpl(UserRepository r){
        this.userRepo = r;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //This is User from UserDetails, not the User entity
        chefUser chefUser = userRepo.findByUsername(username);
        if (chefUser == null) {
            throw new UsernameNotFoundException(username);
        }
        org.springframework.security.core.userdetails.User userS
    }



}
