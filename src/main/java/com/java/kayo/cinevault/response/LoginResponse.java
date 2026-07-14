package com.java.kayo.cinevault.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(@Schema(type = "String", description = "Token do login")
                            String token) {
}
