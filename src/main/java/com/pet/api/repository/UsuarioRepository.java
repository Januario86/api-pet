package com.pet.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	 Optional<Usuario> findByCpf(String cpf);
}
