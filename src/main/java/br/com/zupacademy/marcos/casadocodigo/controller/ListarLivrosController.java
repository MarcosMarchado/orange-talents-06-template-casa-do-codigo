package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.LivroListaResponse;
import br.com.zupacademy.marcos.casadocodigo.model.Livro;
import br.com.zupacademy.marcos.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarLivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/livros")
    public ResponseEntity<List<LivroListaResponse>> listarLivros(){
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(LivroListaResponse.converter(livros));
    }

}
