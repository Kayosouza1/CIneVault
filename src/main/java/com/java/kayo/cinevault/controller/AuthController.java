package com.java.kayo.cinevault.controller;

import com.java.kayo.cinevault.Entity.User;
import com.java.kayo.cinevault.config.TokenService;
import com.java.kayo.cinevault.docs.AuthControllerDoc;
import com.java.kayo.cinevault.exceptions.UsernameOrPasswordInvalidException;
import com.java.kayo.cinevault.mapper.UserMapper;
import com.java.kayo.cinevault.request.LoginRequest;
import com.java.kayo.cinevault.request.UserRequest;
import com.java.kayo.cinevault.response.LoginResponse;
import com.java.kayo.cinevault.response.UserResponse;
import com.java.kayo.cinevault.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinevault/auth")
public class AuthController implements AuthControllerDoc {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
        User savedUser = userService.save(UserMapper.toUser(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));


    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            User user = (User) authenticate.getPrincipal();

            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException e) {
            throw new UsernameOrPasswordInvalidException("Usuario ou senha invalido.");
        }


    }

}
