package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.controller.exception.ObjectNotFoundException;
import br.com.zupacademy.marcos.casadocodigo.controller.validacao.EstadoJaExisteNoPais;
import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Existe;
import br.com.zupacademy.marcos.casadocodigo.model.Estado;
import br.com.zupacademy.marcos.casadocodigo.model.Pais;
import br.com.zupacademy.marcos.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/*Valida se Já existe o Estado no País, caso já exista retorna um erro 400*/
@EstadoJaExisteNoPais
public class NovoEstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Existe(clazz = Pais.class, fieldName = "id")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converter(PaisRepository paisRepository){
        Optional<Pais> optionalPais = paisRepository.findById(this.idPais);
        /*Só lança o erro se não passar pela a validação @Existe/
        Uma camada a mais de segurança para não entrar dados inválidos*/
        Pais pais = optionalPais.orElseThrow(() -> new ObjectNotFoundException("Objeto País não encontrado"));
        return new Estado(nome, pais);
    }
}
