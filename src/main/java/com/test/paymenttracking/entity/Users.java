package com.test.paymenttracking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users extends PayDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstname;
    private String lastname;
    private String contactInfo;

    private String username;

    private String password;

    private String role;

    @OneToOne(mappedBy = "clientManager")
    private Leads leads;

    @OneToOne(mappedBy = "teamLead")
    private Team team;

}
