package com.pet.api.service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.api.dto.ClienteDTO;
import com.pet.api.exceptions.ClienteNotFoundException;
import com.pet.api.model.Cliente;
import com.pet.api.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	    @Autowired
	    private ClienteRepository clienteRepository;
	    
	    @Autowired
	    private ModelMapper modelMapper;

	    public List<Cliente> listarTodos() {
	        List<Cliente> clientes = clienteRepository.findAll();
	        	        
	        if (clientes == null || clientes.isEmpty()) {
	            // Retorne uma lista vazia ou faça o tratamento adequado.
	        	return Collections.emptyList();  // ou um outro tratamento que você achar necessário
	        }
	        return clientes;
	    }

	    public Optional<Cliente> buscarPorId(Long id) throws ClienteNotFoundException{
	    	Optional<Cliente> cliente = clienteRepository.findById(id);
	        if (cliente.isEmpty()) {
	            throw new ClienteNotFoundException("Cliente com ID " + id + " não encontrado");
	        }
	        return cliente;
	    }
	    
	    @Transactional
	    public Cliente salvar(ClienteDTO clienteDTO) {
	    	 Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
	         return clienteRepository.save(cliente);
	    }

	    public void deletar(Long id) {
	        clienteRepository.deleteById(id);
	    }
}