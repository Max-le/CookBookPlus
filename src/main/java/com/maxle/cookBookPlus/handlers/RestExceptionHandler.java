package com.maxle.cookBookPlus.handlers;

import com.maxle.cookBookPlus.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


// https://medium.com/@hantsy/protect-rest-apis-with-spring-security-and-jwt-5fbc90305cc5#de29
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity userNotFound(UserNotFoundException e, WebRequest request){
        log.debug("Handling UserNotFoundException...");
        return ResponseEntity.notFound().build();
    }
}
