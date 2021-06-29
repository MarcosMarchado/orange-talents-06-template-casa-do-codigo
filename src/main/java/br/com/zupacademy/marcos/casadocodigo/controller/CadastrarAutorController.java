package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoAutorRequest;
import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoAutorResponse;
import br.com.zupacademy.marcos.casadocodigo.model.Autor;
import br.com.zupacademy.marcos.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CadastrarAutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/autores")
    public ResponseEntity<NovoAutorResponse> cadastrarAutor(
            @RequestBody @Valid NovoAutorRequest autorRequest){

        Autor autor = autorRequest.converter();
        autorRepository.save(autor);
        return ResponseEntity.ok(new NovoAutorResponse(autor));
    }

}
