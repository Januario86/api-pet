package com.pet.api.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario  implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;

    private String nome;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private Perfil perfil;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorna as autoridades (roles) do usuário
        return Collections.singletonList(new SimpleGrantedAuthority(perfil.getRole()));
    }  

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
}