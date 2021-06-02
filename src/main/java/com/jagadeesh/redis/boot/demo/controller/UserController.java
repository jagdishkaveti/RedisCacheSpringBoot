package com.jagadeesh.redis.boot.demo.controller;

import com.jagadeesh.redis.boot.demo.model.User;
import com.jagadeesh.redis.boot.demo.repo.RedisUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisUserRepository redisUserRepository;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){
        redisUserRepository.save(user);

        return new ResponseEntity("User is created",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getAllUsers(){
        List<User> users = redisUserRepository.findAll();
        return new ResponseEntity(users,HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        User user = redisUserRepository.findById(id);
        System.out.println(user.getName());
        return new ResponseEntity(user,HttpStatus.OK);
    }

}
