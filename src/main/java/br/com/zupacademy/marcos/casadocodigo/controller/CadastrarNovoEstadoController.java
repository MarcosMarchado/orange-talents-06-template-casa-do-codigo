package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoEstadoRequest;
import br.com.zupacademy.marcos.casadocodigo.model.Estado;
import br.com.zupacademy.marcos.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.marcos.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CadastrarNovoEstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    @PostMapping("/estados")
    public ResponseEntity<?> cadastrarEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest){
        Estado estado = novoEstadoRequest.converter(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok().build();

    }

}
