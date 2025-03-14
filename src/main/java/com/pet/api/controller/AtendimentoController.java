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

import com.pet.api.model.Atendimento;
import com.pet.api.service.AtendimentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/atendimentos")
@Tag(name = "Atendimentos", description = "Operações relacionadas a atendimentos")
public class AtendimentoController {

	    @Autowired
	    private AtendimentoService atendimentoService;

	    @GetMapping
	    @Operation(summary = "Listar os Atendimentos", description = "Retorna uma lista com todos os atendimentos")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Atendimentos listados com sucesso")	       
	    })
	    public List<Atendimento> listarTodos() {
	        return atendimentoService.listarTodos();
	    }

	    @GetMapping("/pet/{petId}")
	    @Operation(summary = "Listar os Atendimentos por ID", description = "Retorna uma lista com o atendimento informado")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Atendimento listado com sucesso")	       
	    })
	    public List<Atendimento> buscarPorPet(@PathVariable Long petId) {
	        return atendimentoService.buscarPorPetId(petId);
	    }

	    @PostMapping
	    @Operation(summary = "Criar um novo registro para Atendimento", description = "Cria um novo Atendimento")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Atendimento criado com sucesso")	       
	    })
	    public Atendimento salvar(@RequestBody Atendimento atendimento) {
	        return atendimentoService.salvar(atendimento);
	    }

	    @DeleteMapping("/{id}")
	    @Operation(summary = "Excluir um registro para Atendimento", description = "Exclue um Atendimento")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Atendimento excluído com sucesso"),
	        @ApiResponse(responseCode = "204", description = "Atendimento Informado não Encontrado")	
	    })
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        atendimentoService.deletar(id);
	        return ResponseEntity.noContent().build();
	    }
}

