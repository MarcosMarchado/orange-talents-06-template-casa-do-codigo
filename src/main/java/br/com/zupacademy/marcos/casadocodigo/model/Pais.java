package br.com.zupacademy.marcos.casadocodigo.model;

import javax.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

}
