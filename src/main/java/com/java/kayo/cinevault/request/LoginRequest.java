package com.java.kayo.cinevault.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(@Schema(type = "String", description = "Email do login")
                           String email,
                           @Schema(type = "String", description = "Senha do login")
                           String password) {
}
