package com.bmc.userservice.service;

import com.bmc.userservice.exception.InvalidInputException;
import com.bmc.userservice.exception.ResourceUnAvailableException;
import com.bmc.userservice.model.User;
import com.bmc.userservice.repository.UserRepository;
import com.bmc.userservice.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    public User register(User user) throws InvalidInputException {
        ValidationUtils.validate(user);
        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
        notify(user);
        return user;
    }

    public User getUser(String id) {
        return Optional.ofNullable(userRepository.findById(id))
            .get()
            .orElseThrow(ResourceUnAvailableException::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    private void notify(User user){
        notificationService.notifyUser(user);
    }
}
