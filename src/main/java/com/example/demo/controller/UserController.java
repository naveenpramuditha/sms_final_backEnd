package com.example.demo.controller;


import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        logger.trace("New Student is Added");

        return userRepository.save(newUser);
    }

    @GetMapping("/users")

    List<User> getAllUsers(){
        logger.trace("List of All Students");
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){

        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User  updateUser(@RequestBody User newUser,@PathVariable Long id){
        logger.trace("Student Details Updated");
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setRegno(newUser.getRegno());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        logger.trace("Studetn Deleted");
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);

        }
        userRepository.deleteById(id);
        return "User with id "+id+" has deleted Completely.";
    }
}
