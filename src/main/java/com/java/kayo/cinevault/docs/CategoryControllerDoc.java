package com.java.kayo.cinevault.docs;

import com.java.kayo.cinevault.request.CategoryRequest;
import com.java.kayo.cinevault.response.CategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Category", description = "Recurso responsavel pelo gerenciamento de categorias.")
public interface CategoryControllerDoc {


    @Operation(summary = "Busca categorias", description = "Metodo responsável por exibir todas as categorias.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categorias encontradas com sucesso.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))))
    @ApiResponse(responseCode = "404", description = "Categorias não encontradas.", content = @Content())
    ResponseEntity<List<CategoryResponse>> getAllCategories();


    @Operation(summary = "Cadastra categorias", description = "Metodo responsável por salvar categorias",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso", content = @Content())
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content())
    ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request);


    @Operation(summary = "Busca categoria pelo ID", description = "Metodo responsável por buscar a categoria pelo seu id.",
        security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.", content = @Content())
    ResponseEntity<CategoryResponse> getById(@PathVariable Long id);


    @Operation(summary = "Deleta categoria por ID", description = "Deleta categoria pelo seu id.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada.")
    ResponseEntity<?> deleteCategory(@PathVariable Long id);



}
