package com.java.kayo.cinevault.docs;

import com.java.kayo.cinevault.request.StreamingRequest;
import com.java.kayo.cinevault.response.StreamingResponse;
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

@Tag(name = "Streaming", description = "Recurso responsavel por gerenciar os streamings")
public interface StreamingControllerDoc {


    @Operation(summary = "Busca todos os streamings", description = "Metodo responsavel por exibir todos os streamings",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streamings encontrados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class))))
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado", content = @Content())
    ResponseEntity<List<StreamingResponse>> getAllStreaming();


    @Operation(summary = "Cadastra streaming", description = "Metodo responsável por cadastrar streamings",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Streaming criado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content())
    ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request);


    @Operation(summary = "Busca por ID", description = "Metodo responsável por buscar streaming por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming encontrado com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado", content = @Content())
    ResponseEntity<StreamingResponse> getById(@PathVariable Long id);


    @Operation(summary = "Deleta streaming por ID", description = "Metodo responsável por deletar streaming",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Streaming deletado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado.")
    ResponseEntity<?> deleteStreaming(@PathVariable Long id);
}
