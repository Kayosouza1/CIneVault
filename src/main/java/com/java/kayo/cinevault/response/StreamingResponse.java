package com.java.kayo.cinevault.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(@Schema(type = "Long", description = "Id do streaming")
                                Long id,
                                @Schema(type = "String", description = "Nome do streaming")
                                String name) {
}
