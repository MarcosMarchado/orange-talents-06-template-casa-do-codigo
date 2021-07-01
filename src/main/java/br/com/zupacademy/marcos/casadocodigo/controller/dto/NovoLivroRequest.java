package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.controller.exception.ObjectNotFoundException;
import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Existe;
import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Unico;
import br.com.zupacademy.marcos.casadocodigo.model.Autor;
import br.com.zupacademy.marcos.casadocodigo.model.Categoria;
import br.com.zupacademy.marcos.casadocodigo.model.Livro;
import br.com.zupacademy.marcos.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcos.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class NovoLivroRequest {

    @NotBlank
    @Unico(clazz = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @Unico(clazz = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future()
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @Existe(clazz = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @Existe(clazz = Autor.class, fieldName = "id")
    private Long idAutor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(idCategoria);
        Optional<Autor> optionalAutor = autorRepository.findById(idAutor);

        Categoria categoria = optionalCategoria.orElseThrow(() ->
                        new ObjectNotFoundException("Objeto do tipo Categoria não foi encontrado"));
        Autor autor = optionalAutor.orElseThrow(() ->
                new ObjectNotFoundException("Objeto do tipo Autor não foi encontrado"));

        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas,
                isbn, dataPublicacao, categoria, autor);
    }

}
