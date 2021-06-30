package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Unico;
import br.com.zupacademy.marcos.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCategoriaRequest {

    @NotNull
    @NotBlank
    @Unico(clazz = Categoria.class, fieldName = "nome", message = "Categoria já existe")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(nome);
    }
}
