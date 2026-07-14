package com.java.kayo.cinevault.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "String", description = "Nome do filme.")
                           @NotEmpty(message = "Titulo do filme é obrigatório.")
                           String title,
                           @Schema(type = "String", description = "Descrição do filme.")
                           String description,
                           @Schema(type = "Date", description = "Data da lançamento do filme.")
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,
                           @Schema(type = "Double", description = "Score do filme.")
                           double rating,
                           @Schema(type = "array", description = "Lista de codigos de categorias")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de codigos de streamings")
                           List<Long> streamings) {
}
