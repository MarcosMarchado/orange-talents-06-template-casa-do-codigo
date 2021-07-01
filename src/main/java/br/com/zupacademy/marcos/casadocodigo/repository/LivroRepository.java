package br.com.zupacademy.marcos.casadocodigo.repository;

import br.com.zupacademy.marcos.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
