package br.com.zupacademy.marcos.casadocodigo.repository;

import br.com.zupacademy.marcos.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByPaisId(Long idPais);
    Estado findByIdAndPaisId(Long idEstado, Long idPais);

}
