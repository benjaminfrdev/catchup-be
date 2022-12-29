package com.project.be.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Entity(name = "account")
@NoArgsConstructor
public class AccountEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* column phone number */
    @Column(name = "phone_number",nullable = false, unique = true)
    private String phoneNumber;


    /* column password */
    @Column(name = "password",nullable = false)
    private String password;


}
