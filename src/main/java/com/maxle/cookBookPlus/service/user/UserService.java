package com.maxle.cookBookPlus.service.user;

import lombok.NonNull;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(@NonNull Long id);
}