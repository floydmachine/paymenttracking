package com.test.paymenttracking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {

    private String firstname;
    private String lastname;
    private String contactInfo;
    private String username;
    private String role;
}
