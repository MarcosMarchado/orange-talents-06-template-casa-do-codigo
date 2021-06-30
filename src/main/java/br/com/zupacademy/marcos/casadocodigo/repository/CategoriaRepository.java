package br.com.zupacademy.marcos.casadocodigo.repository;

import br.com.zupacademy.marcos.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
