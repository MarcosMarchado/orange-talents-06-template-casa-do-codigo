package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Unico;
import br.com.zupacademy.marcos.casadocodigo.model.Pais;

import javax.validation.constraints.NotNull;

public class NovoPaisRequest {

    @NotNull
    @Unico(clazz = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais converter() {
        return new Pais(nome);
    }
}
