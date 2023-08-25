package com.test.paymenttracking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    private String teamName;
    private String clientManagers;
    private String createdBy;
    private String role;
    @OneToOne
    @JoinColumn(name = "teamLeadId")
    private Users teamLead;


}
