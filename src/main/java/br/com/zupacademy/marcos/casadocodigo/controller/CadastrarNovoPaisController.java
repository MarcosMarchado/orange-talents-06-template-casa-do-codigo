package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoPaisRequest;
import br.com.zupacademy.marcos.casadocodigo.model.Pais;
import br.com.zupacademy.marcos.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CadastrarNovoPaisController {

    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    @PostMapping("/paises")
    public ResponseEntity<?> cadastrarPais(@RequestBody @Valid NovoPaisRequest novoPaisRequest){
        Pais pais = novoPaisRequest.converter();
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }
}
