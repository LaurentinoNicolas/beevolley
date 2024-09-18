package com.laurentino.beevolley.controller;

import com.laurentino.beevolley.config.KeycloakProvider;
import com.laurentino.beevolley.http.requests.LoginRequest;
import com.laurentino.beevolley.http.requests.UserRequest;
import com.laurentino.beevolley.http.responses.UserResponse;
import com.laurentino.beevolley.service.KeycloakAdminClientService;
import com.laurentino.beevolley.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    private final KeycloakAdminClientService keyCloakService;



    @PostMapping("/public/create")
    public ResponseEntity<Void> createNewUser(@RequestBody @Valid UserRequest request){
        return keyCloakService.createKeycloakUser(request);
    }

    @GetMapping()
    public ResponseEntity<UserResponse> getUser(@RequestParam String email){
        return ResponseEntity.ok(service.getUser(email));
    }

    @GetMapping("/public/hello")
    public ResponseEntity<String> ola(){
        return ResponseEntity.ok("ola mundo public!");
    }

    @GetMapping("/private/hello")
    public ResponseEntity<String> olaPrivado(){
        return ResponseEntity.ok("ola mundo privado!");
    }

    @PostMapping("/public/login")
    public ResponseEntity<AccessTokenResponse> login(@NotNull @RequestBody LoginRequest loginRequest) {
        return keyCloakService.loginKeyCloak(loginRequest);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
