package com.bmc.userservice.util;

import com.bmc.userservice.exception.InvalidInputException;
import com.bmc.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationUtils {

    public static void validate(User user) throws InvalidInputException {
        List<String> errorFields = new ArrayList<>();
        if(user.getEmailId() == null || !user.getEmailId().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            errorFields.add("Email Id");
        }

        if(user.getMobile() == null || !user.getMobile().matches("^\\d{10}$")){
            errorFields.add("Mobile");
        }
        if(user.getFirstName() == null || !user.getFirstName().matches("^[a-zA-Z\\\\s]{1,10}$")){
            errorFields.add("First Name");
        }
        if(user.getLastName() == null || !user.getLastName().matches("^[a-zA-Z\\\\s]{1,10}$")){
            errorFields.add("Last Name");
        }
        if(errorFields.size()>0) throw new InvalidInputException(errorFields);
    }
}
