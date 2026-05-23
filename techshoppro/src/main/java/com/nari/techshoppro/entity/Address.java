package com.nari.techshoppro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phone;

    private String city;

    private String state;

    private String country;

    private String pincode;

    @Column(length = 1000)
    private String addressLine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}