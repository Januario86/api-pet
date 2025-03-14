package com.pet.api.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(
		Long id,
		@NotBlank(message = "O nome é obrigatório") 
		String nome,

		@CPF(message = "CPF inválido") 
		String cpf
		) 
{}
