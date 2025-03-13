package com.pet.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.api.model.Usuario;
import com.pet.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    public Optional<Usuario> buscarPorCpf(String cpf) {
//        return usuarioRepository.findByCpf(cpf);
//    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}