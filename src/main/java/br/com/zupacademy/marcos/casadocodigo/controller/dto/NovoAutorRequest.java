package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Unico;
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
    @Unico(clazz = Autor.class, fieldName = "email", message = "Email já existe")
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter(){
        return new Autor(nome, email, descricao);
    }
}
