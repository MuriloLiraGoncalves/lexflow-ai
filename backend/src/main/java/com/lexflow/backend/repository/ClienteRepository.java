package com.lexflow.backend.repository;

import com.lexflow.backend.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong sequencia = new AtomicLong(1);

    public Cliente salvar(Cliente cliente) {
        cliente.setId(sequencia.getAndIncrement());
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    public boolean existePorCpf(String cpf) {
        return clientes.stream().anyMatch(c -> c.getCpf().equals(cpf));
    }
}