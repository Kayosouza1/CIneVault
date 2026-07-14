package com.java.kayo.cinevault.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "Long", description = "ID do filme")
                            Long id,
                            @Schema(type = "String", description = "Nome do filme")
                            String title,
                            @Schema(type = "String", description = "Descrição do filme")
                            String description,
                            @Schema(type = "Date", description = "Data de lançamento do filme")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate releaseDate,
                            @Schema(type = "Double", description = "Score do filme")
                            double rating,
                            @Schema(type = "Array", description = "Lista de codigo de categorias")
                            List<CategoryResponse> categories,
                            @Schema(type = "Array", description = "Lista de codigo de streamings")
                            List<StreamingResponse> streamings) {
}
