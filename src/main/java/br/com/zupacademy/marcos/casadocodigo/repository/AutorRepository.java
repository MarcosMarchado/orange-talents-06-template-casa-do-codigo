package br.com.zupacademy.marcos.casadocodigo.repository;

import br.com.zupacademy.marcos.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByEmail(String email);
}
