package com.jagadeesh.redis.boot.demo.exception;

import com.jagadeesh.redis.boot.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebResult;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RedisExceptionCustomAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<User> handleUserNotFoundException(NullPointerException nEx , WebResult request){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "City not found");

        User user = new User();
        user.setAge(10);
        user.setName("Dummy User");

        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);


    }

}
