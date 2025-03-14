package com.pet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.api.model.Contato;
import com.pet.api.model.Pet;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	List<Contato> findByClienteId(Long clienteId);
}
