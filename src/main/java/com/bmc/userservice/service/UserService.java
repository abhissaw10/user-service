package com.bmc.userservice.service;

import com.bmc.userservice.model.User;
import com.bmc.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    public User register(User user) {
        user.setId(UUID.randomUUID().toString());
        userRepository.save(user);
        notify(user);
        return user;
    }

    public User getUser(String id) {
        return userRepository.findById(id).get();
    }
    private void notify(User user){
        notificationService.notifyUser(user);
    }
}
