package com.pet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.api.model.Contato;
import com.pet.api.repository.ContatoRepository;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    public List<Contato> buscarPorClienteId(Long clienteId) {
        return contatoRepository.findByClienteId(clienteId);
    }

    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void deletar(Long id) {
        contatoRepository.deleteById(id);
    }
}