package com.armby.soshapi.user;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getOneUser(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User addOneUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @PatchMapping
    public User updateOneUser(@RequestBody User updatedUser) {
        return userRepository.save(updatedUser);
    }

    @DeleteMapping("/{id}")
    public User deleteOneUser(@PathVariable long id) {
        User removedUser = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return removedUser;
    }
}
