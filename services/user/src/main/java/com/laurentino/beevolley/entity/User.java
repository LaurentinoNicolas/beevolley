package com.laurentino.beevolley.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true,  nullable = false)
    private String email;

    private String password;

    private LocalDate birthdate;

}
