package com.bmc.userservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class User {
    @Id
    private String id;
    private String firstLame;
    private String lastName;
    private String dob;
    private String mobile;
    private String emailId;
    private String createdDate;
}
