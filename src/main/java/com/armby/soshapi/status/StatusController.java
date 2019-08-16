package com.armby.soshapi.status;

import com.armby.soshapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// This is a controller
@RestController
// The base url is...
@RequestMapping("api/v1/statuses")
public class StatusController {

    // The dependencies that were injected:
    @Autowired
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    // Constructor created for injected dependencies
    public StatusController(StatusRepository statusRepository, UserRepository userRepository) {
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    // Get all statuses
    @GetMapping
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    // Get one status using the path variable "id" from the url
    @GetMapping("/{id}")
    public Optional<Status> getOneStatus(@PathVariable long id) {
        return statusRepository.findById(id);
    }

    // Add one status
    @PostMapping("/user/{userId}")
    public Optional<Status> addOneStatus(@PathVariable long userId, @RequestBody Status status) {
        // Go find a user with the id path variable
        return userRepository.findById(userId).map(user -> {
            // Set the created_at field
            status.setCreated_at(new Date());
            // Set the user to be the user that was found with findById
            status.setUser(user);
            // Save the status with the updated fields
            return statusRepository.save(status);
        });
    }

    // Update existing status
    // Make sure to send ENTIRE status, not just pieces of it
    @PatchMapping
    public Status updateOneStatus(@RequestBody Status updatedStatus) {
        return statusRepository.save(updatedStatus);
    }

    // Delete a status with the status id
    @DeleteMapping("/{id}")
    public Status deleteOneStatus(@PathVariable long id) {
        Status removedStatus = statusRepository.findById(id).get();
        statusRepository.deleteById(id);
        return removedStatus;
    }

}