package com.java.kayo.cinevault.docs;

import com.java.kayo.cinevault.request.LoginRequest;
import com.java.kayo.cinevault.request.UserRequest;
import com.java.kayo.cinevault.response.LoginResponse;
import com.java.kayo.cinevault.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "AuthController", description = "Recurso responsável por gerenciar a autenticação")
public interface AuthControllerDoc {


    @Operation(summary = "Registra a autenticação.", description = "Metodo responsável por registrar a autenticação",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Autenticação registrada com sucesso.", content = @Content())
    @ApiResponse(responseCode = "400", description = "Requisição mal formulada", content = @Content())
    ResponseEntity<UserResponse> register(@RequestBody UserRequest request);


    @Operation(summary = "Loga o usuario", description = "Metodo responsável por logar e gerar o token do usuário.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Login efetuado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "400", description = "Usuario ou senha invalido.", content = @Content())
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);


}
