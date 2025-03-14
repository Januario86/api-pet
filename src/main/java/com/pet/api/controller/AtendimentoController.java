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

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

	    @Autowired
	    private AtendimentoService atendimentoService;

	    @GetMapping
	    public List<Atendimento> listarTodos() {
	        return atendimentoService.listarTodos();
	    }

	    @GetMapping("/pet/{petId}")
	    public List<Atendimento> buscarPorPet(@PathVariable Long petId) {
	        return atendimentoService.buscarPorPetId(petId);
	    }

	    @PostMapping
	    public Atendimento salvar(@RequestBody Atendimento atendimento) {
	        return atendimentoService.salvar(atendimento);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        atendimentoService.deletar(id);
	        return ResponseEntity.noContent().build();
	    }
}

