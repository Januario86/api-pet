package com.pet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.api.model.Pet;
import com.pet.api.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository petsRepository;

    public List<Pet> listarTodos() {
        return petsRepository.findAll();
    }

//    public List<Pet> buscarPorClienteId(Long clienteId) {
//        return petsRepository.findByClienteId(clienteId);
//    }

    public Pet salvar(Pet pet) {
        return petsRepository.save(pet);
    }

    public void deletar(Long id) {
        petsRepository.deleteById(id);
    }
}