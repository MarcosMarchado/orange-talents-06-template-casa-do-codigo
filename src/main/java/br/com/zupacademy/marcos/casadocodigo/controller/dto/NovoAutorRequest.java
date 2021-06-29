package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.controller.validacao.EmailJaExiste;
import br.com.zupacademy.marcos.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotNull
    @NotBlank
    private String nome;

    @Email
    @NotNull
    @NotBlank
    @EmailJaExiste
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter(){
        return new Autor(nome, email, descricao);
    }
}
