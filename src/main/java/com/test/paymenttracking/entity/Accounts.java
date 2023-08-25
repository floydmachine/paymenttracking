package com.test.paymenttracking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts extends PayDate{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private double dealAmount;
    private double totalPayments;
    private double remainingBalance;
    private LocalDateTime paymentDueDate;

    @OneToMany(mappedBy = "account")
    private Set<Payment> payments;
    @OneToOne
    @JoinColumn(name = "leadId")
    private Leads leads;
    private String status;



}
