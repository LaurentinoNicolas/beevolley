package com.laurentino.beevolley.http.responses;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String name,
        String email,
        String password,
        LocalDate birthdate
) {
}
