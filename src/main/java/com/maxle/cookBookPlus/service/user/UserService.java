package com.maxle.cookBookPlus.service.user;

import com.maxle.cookBookPlus.entities.User;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(@NonNull Long id);
}
