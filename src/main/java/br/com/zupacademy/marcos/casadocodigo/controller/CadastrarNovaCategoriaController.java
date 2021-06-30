package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovaCategoriaRequest;
import br.com.zupacademy.marcos.casadocodigo.model.Categoria;
import br.com.zupacademy.marcos.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CadastrarNovaCategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    @PostMapping("/categorias")
    public ResponseEntity<?> cadastrarCategoria(
            @RequestBody @Valid NovaCategoriaRequest categoriaRequest){

        Categoria categoria = categoriaRequest.converter();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }

}
