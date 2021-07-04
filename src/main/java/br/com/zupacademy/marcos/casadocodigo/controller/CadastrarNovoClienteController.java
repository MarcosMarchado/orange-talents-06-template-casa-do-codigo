package br.com.zupacademy.marcos.casadocodigo.controller;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoClienteRequest;
import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoClienteResponse;
import br.com.zupacademy.marcos.casadocodigo.model.Cliente;
import br.com.zupacademy.marcos.casadocodigo.repository.ClienteRepository;
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
public class CadastrarNovoClienteController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @PostMapping("/clientes")
    public ResponseEntity<NovoClienteResponse> cadastrarCliente(@RequestBody @Valid NovoClienteRequest novoClienteRequest){
        Cliente cliente = novoClienteRequest.converter(estadoRepository, paisRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(new NovoClienteResponse(cliente));
    }

}
