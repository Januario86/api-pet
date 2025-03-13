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

@RestController
@RequestMapping("/racas")
public class RacaController {

    @Autowired
    private RacaService racaService;

    @GetMapping
    public List<Raca> listarTodos() {
        return racaService.listarTodos();
    }

    @PostMapping
    public Raca salvar(@RequestBody Raca raca) {
        return racaService.salvar(raca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        racaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
