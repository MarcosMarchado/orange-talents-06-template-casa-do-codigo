package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoLivroRequest;
import br.com.zupacademy.marcos.casadocodigo.model.Livro;
import br.com.zupacademy.marcos.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcos.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.marcos.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CadastrarNovoLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    @PostMapping("/livros")
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest){
        Livro livro = novoLivroRequest.converter(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }


}
