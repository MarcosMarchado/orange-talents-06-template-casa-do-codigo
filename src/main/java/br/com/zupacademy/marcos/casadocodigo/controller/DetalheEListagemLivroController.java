package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.LivroDetalheResponse;
import br.com.zupacademy.marcos.casadocodigo.controller.dto.LivroListaResponse;
import br.com.zupacademy.marcos.casadocodigo.controller.exception.ObjectNotFoundException;
import br.com.zupacademy.marcos.casadocodigo.model.Livro;
import br.com.zupacademy.marcos.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class DetalheEListagemLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroListaResponse>> listarLivros(){
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(LivroListaResponse.converter(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheResponse> detalharLivro(@PathVariable Long id){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        Livro livro = optionalLivro
                .orElseThrow(() -> new ObjectNotFoundException("Livro com o identificador " + id + " não encontrado"));
        return ResponseEntity.ok(new LivroDetalheResponse(livro));
    }

}
