package com.laurentino.beevolley.service;


import com.laurentino.beevolley.http.requests.UserRequest;
import com.laurentino.beevolley.http.responses.UserResponse;
import com.laurentino.beevolley.repository.UserRepository;
import com.laurentino.beevolley.utils.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;


    public UserResponse getUser(String email) {
        return repository.findByEmail(email)
                .map(mapper::toUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User not found with the email:: " + email));
    }

    public Long createUser(@Valid UserRequest request){

        var userFromDB = repository.findByEmail(request.email());

        if(userFromDB.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = mapper.toUser(request);

        return repository.save(user).getId();
    }

    public List<UserResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toUserResponse)
                .collect(Collectors.toList());
    }
}
