package br.com.zupacademy.marcos.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String cidade;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    public Cliente() {
    }

    public Cliente(String email, String nome,
                   String sobrenome, String documento,
                   String endereco, String complemento,
                   String telefone, String cep,
                   String cidade, Pais pais) {

        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
