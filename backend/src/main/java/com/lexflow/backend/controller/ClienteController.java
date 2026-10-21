package com.lexflow.backend.controller;

import com.lexflow.backend.model.Cliente;
import com.lexflow.backend.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return service.cadastrar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }
}