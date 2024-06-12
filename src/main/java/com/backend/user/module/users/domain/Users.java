package com.backend.user.module.users.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_authentication")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "user_names")
    private String userName;

    @Column(name = "user_ages")
    private Integer userAge;

    @Column(name = "user_address")
    private String userAddress;

}
