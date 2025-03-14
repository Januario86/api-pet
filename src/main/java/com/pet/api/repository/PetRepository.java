package com.pet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.api.model.Cliente;
import com.pet.api.model.Pet;
import com.pet.api.model.Raca;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	
	List<Pet> findByCliente(Cliente cliente);
    
	List<Pet> findByClienteId(Long clienteId);
    
    List<Pet> findByRaca(Raca raca);
    
    List<Pet> findByRacaId(Long racaId);
    
    List<Pet> findByNome(String nome);    
}
