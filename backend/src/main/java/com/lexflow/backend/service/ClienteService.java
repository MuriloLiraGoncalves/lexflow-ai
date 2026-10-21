package com.lexflow.backend.service;

import com.lexflow.backend.model.Cliente;
import com.lexflow.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(Cliente cliente) {
        if (repository.existePorCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("Já existe um cliente com este CPF.");
        }
        return repository.salvar(cliente);
    }

    public List<Cliente> listar() {
        return repository.listarTodos();
    }
}