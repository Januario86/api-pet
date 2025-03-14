package com.pet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.api.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
   List<Atendimento> findByPetsId(Long petId);
}
