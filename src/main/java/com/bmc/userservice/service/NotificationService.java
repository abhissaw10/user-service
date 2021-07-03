package com.bmc.userservice.service;

import com.bmc.userservice.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class NotificationService {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    @Value("${doctor.registration.notification}")
    private String appointmentConfirmationTopic;

    public void notifyUser(User user){
        log.info(user);
        kafkaTemplate.send(appointmentConfirmationTopic,user);
    }
}
