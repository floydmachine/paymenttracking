package com.test.paymenttracking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.print.Book;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Payment extends PayDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private LocalDateTime paymentDate;
    private double amount;
    private String method;
    private String paymentCategory;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Accounts account;
    private String status;


}
