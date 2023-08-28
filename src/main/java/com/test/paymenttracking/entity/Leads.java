package com.test.paymenttracking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "leads")
public class Leads extends PayDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leadId;
    private String leadName;
    @OneToOne
    @JoinColumn(name = "clientManagerId")
    private Users clientManager;

    @OneToOne(mappedBy = "leads")
    private Accounts account;

    private String status;


}
