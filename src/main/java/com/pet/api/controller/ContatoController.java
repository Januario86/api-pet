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

import com.pet.api.model.Contato;
import com.pet.api.service.ContatoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/contatos")
@Tag(name = "Contatos", description = "Operações relacionadas a contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    @Operation(summary = "Listar todos os Contatos", description = "Retorna uma lista de Contatos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contatos listado com sucesso")      
    })
    public List<Contato> listarTodos() {
        return contatoService.listarTodos();
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Listar todos os Contatos selecionado pelo Identificador", description = "Retorna o contato informado pelo Identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contato informado com sucesso")      
    })
    public List<Contato> buscarPorCliente(@PathVariable Long clienteId) {
        return contatoService.buscarPorClienteId(clienteId);
    }

    @PostMapping
    @Operation(summary = "Criar um novo registro de Contato", description = "Cria um novo Contato")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "contato criado com sucesso")        
    })
    public Contato salvar(@RequestBody Contato contato) {
        return contatoService.salvar(contato);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro para Contato", description = "Exclue um Contato")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Contato excluído com sucesso"),
        @ApiResponse(responseCode = "204", description = "Contato Informado não Encontrado")	
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}