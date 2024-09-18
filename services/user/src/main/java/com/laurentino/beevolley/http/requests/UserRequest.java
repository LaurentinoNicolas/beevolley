package com.laurentino.beevolley.http.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRequest(

        Long id,
        @NotNull(message="User name is required")
        String name,
        @NotNull(message="User email is required")
        @Email(message = "User email is not a valid email address")
        String email,
        @NotNull(message = "User password is required")
        String password,
        @NotNull(message = "User birthdate is required")
        LocalDate birthdate

) {
}
