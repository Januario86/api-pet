package com.pet.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.api.dto.ClienteDTO;
import com.pet.api.model.Cliente;
import com.pet.api.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Operações relacionadas a clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@Operation(summary = "Listar todos os clientes", description = "Retorna uma lista de clientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clientes listado com sucesso")      
    })
	public List<Cliente> listarClientes() {
	    return clienteService.listarTodos();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Listar o cliente selecionado pelo Identificador", description = "Retorna o cliente informado pelo Identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente informado com sucesso")      
    })
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo registro de Cliente", description = "Cria um novo cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso")        
    })
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO) {
    	ClienteDTO clienteSalvo = clienteService.salvar(clienteDTO);
         return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro para Cliente", description = "Exclue um Cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente excluído com sucesso"),
        @ApiResponse(responseCode = "204", description = "Cliente Informado não Encontrado")	
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
