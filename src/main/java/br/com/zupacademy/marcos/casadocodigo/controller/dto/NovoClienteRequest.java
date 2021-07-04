package br.com.zupacademy.marcos.casadocodigo.controller.dto;

import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Documento;
import br.com.zupacademy.marcos.casadocodigo.controller.validacao.EstadoPais;
import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Existe;
import br.com.zupacademy.marcos.casadocodigo.controller.validacao.Unico;
import br.com.zupacademy.marcos.casadocodigo.model.Cliente;
import br.com.zupacademy.marcos.casadocodigo.model.Estado;
import br.com.zupacademy.marcos.casadocodigo.model.Pais;
import br.com.zupacademy.marcos.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.marcos.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


@EstadoPais
public class NovoClienteRequest {

    @NotBlank
    @Email
    @Unico(clazz = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Documento
    @Unico(clazz = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;
    @NotNull
    @Existe(clazz = Pais.class, fieldName = "id")
    private Long idPais;

    private Long idEstado;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Cliente converter(EstadoRepository estadoRepository, PaisRepository paisRepository){

        Optional<Pais> optionalPais = paisRepository.findById(idPais);

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco,
                complemento, telefone, cep, cidade, optionalPais.get());

        if(idEstado != null){
            Optional<Estado> optionalEstado = estadoRepository.findById(idEstado);
            cliente.setEstado(optionalEstado.get());
        }

        return cliente;
    }

}
