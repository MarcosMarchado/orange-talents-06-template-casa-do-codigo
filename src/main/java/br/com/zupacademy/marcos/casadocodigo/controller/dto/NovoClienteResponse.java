package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.model.Cliente;

public class NovoClienteResponse {

    private Long id;

    public Long getId() {
        return id;
    }

    public NovoClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
    }
}
