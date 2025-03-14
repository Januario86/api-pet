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

import com.pet.api.model.Pet;
import com.pet.api.service.PetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pets")
@Tag(name = "Pets", description = "Operações relacionadas a pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    @Operation(summary = "Listar todos os Pets", description = "Retorna uma lista de Pets")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clientes listado com sucesso")      
    })
    public List<Pet> listarTodos() {
        return petService.listarTodos();
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Listar todos os pets selecionado pelo Identificador", description = "Retorna o pet informado pelo Identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pet informado com sucesso")      
    })
    public List<Pet> buscarPorPet(@PathVariable Long clienteId) {
        return petService.buscarPorClienteId(clienteId);
    }

    @PostMapping
    @Operation(summary = "Criar um novo registro de Pet", description = "Cria um novo Pet")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pet criado com sucesso")        
    })
    public Pet salvar(@RequestBody Pet pet) {
        return petService.salvar(pet);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro para Pet", description = "Exclue um Pet")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pet excluído com sucesso"),
        @ApiResponse(responseCode = "204", description = "Pet Informado não Encontrado")	
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        petService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
