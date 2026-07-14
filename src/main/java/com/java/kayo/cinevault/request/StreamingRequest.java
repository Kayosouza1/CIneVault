package com.java.kayo.cinevault.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@Schema(type = "String", description = "Nome do streaming")
                               @NotEmpty(message = "Nome do streaming é obrigatório.")
                               String name) {
}
