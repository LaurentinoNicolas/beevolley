package com.laurentino.beevolley.utils;

import com.laurentino.beevolley.entity.User;
import com.laurentino.beevolley.http.requests.UserRequest;
import com.laurentino.beevolley.http.responses.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {

    public User toUser(@Valid UserRequest request){
        return User.builder()
                .id(request.id())
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .birthdate(request.birthdate())
                .build();
    }


    public User toUser(@Valid UserResponse response){
        return User.builder()
                .id(response.id())
                .name(response.name())
                .email(response.email())
                .birthdate(response.birthdate())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getName(),
                user.getPassword(),
                user.getBirthdate()
        );
    }

}
