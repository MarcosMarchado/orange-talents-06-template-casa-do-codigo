package br.com.zupacademy.marcos.casadocodigo.repository;

import br.com.zupacademy.marcos.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
