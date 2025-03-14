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

import com.pet.api.model.Endereco;
import com.pet.api.service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereço", description = "Operações relacionadas a endereço")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoService.listarTodos();
    }

    @GetMapping("/enderecos/{clienteId}")
    @Operation(summary = "Listar todos os Endereços selecionado pelo Identificador do Cliente", description = "Retorna o endereço informado pelo Identificador do Cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço informado com sucesso")      
    })
    public List<Endereco> buscarPorCliente(@PathVariable Long clienteId) {
        return enderecoService.buscarPorClienteId(clienteId);
    }

    @PostMapping
    @Operation(summary = "Criar um novo registro de Endereço de Cliente", description = "Cria um novo Endereço")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso")        
    })
    public Endereco salvar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro para endereço", description = "Exclue um Endereço")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Endereço excluído com sucesso"),
        @ApiResponse(responseCode = "204", description = "Identificador Informado não Encontrado")	
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}