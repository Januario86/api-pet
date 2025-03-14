package com.pet.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.api.model.Raca;
import com.pet.api.service.RacaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/racas")
@Tag(name = "Raça", description = "Operações relacionadas a raça")
public class RacaController {

    @Autowired
    private RacaService racaService;

    @GetMapping
    @Operation(summary = "Listar todas as raças cadastradas", description = "Retorna uma lista contendo a raça dos pets cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Raça listada com sucesso")      
    })
    public List<Raca> listarTodos() {
        return racaService.listarTodos();
    }

    @PostMapping
    @Operation(summary = "Criar um novo registro de raça", description = "Cria um novo raça")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Raça criada com sucesso")        
    })
    public Raca salvar(@RequestBody Raca raca) {
        return racaService.salvar(raca);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro para raça", description = "Exclue uma raça de acordo com o Identificador informado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Raça excluída com sucesso"),
        @ApiResponse(responseCode = "204", description = "Idenfiticador para a raça informada não Encontrado")	
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        racaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
