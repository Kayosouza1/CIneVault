package com.java.kayo.cinevault.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserRequest(@Schema(type = "String", description = "nome do usuario")
                          String name,
                          @Schema(type = "String", description = "Email do usuario")
                          String email,
                          @Schema(type = "String", description = "Senha do usuario")
                          String password) {
}
