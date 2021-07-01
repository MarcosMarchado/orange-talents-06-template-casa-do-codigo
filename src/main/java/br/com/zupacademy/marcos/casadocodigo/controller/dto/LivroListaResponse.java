package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroListaResponse {

    private Long id;
    private String nome;

    public LivroListaResponse(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static List<LivroListaResponse> converter(List<Livro> livros) {
        return livros.stream().map(livro -> new LivroListaResponse(livro))
                .collect(Collectors.toList());
    }
}
