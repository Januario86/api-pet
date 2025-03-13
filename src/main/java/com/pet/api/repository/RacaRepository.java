package com.pet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.api.model.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {

}
