package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class LivroDetalheResponse {

    private String titulo;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private Integer numeroDePaginas ;
    private String isbn;
    private String dataPublicacao;
    private AutorResponse autor;


    public LivroDetalheResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.autor = new AutorResponse(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorResponse getAutor() {
        return autor;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
