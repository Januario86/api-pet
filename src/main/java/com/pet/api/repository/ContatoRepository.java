package com.pet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.api.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
