package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.models.entities.User;
import com.maxle.cookBookPlus.repositories.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(@NonNull Long id) {
        return this.userRepo.findById(id).orElse(null);
    }
}