package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import br.com.zupacademy.marcos.casadocodigo.controller.dto.NovoClienteRequest;
import br.com.zupacademy.marcos.casadocodigo.model.Estado;
import br.com.zupacademy.marcos.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class EstadoPaisValidator implements ConstraintValidator<EstadoPais, NovoClienteRequest> {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void initialize(EstadoPais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(NovoClienteRequest value, ConstraintValidatorContext context) {

        //Retonará uma lista se tiver Estados no País
        List<Estado> paisTemEstados = estadoRepository.findByPaisId(value.getIdPais());

        //Só trará um estado
        Estado paisTemOestado = estadoRepository.findByIdAndPaisId(value.getIdEstado(), value.getIdPais());

        //Se no País possui estados e não foi passado um Estado
        if(value.getIdEstado() == null  && !paisTemEstados.isEmpty()){
            return false;
        }

        if(value.getIdEstado() != null && paisTemOestado == null){
            return false;
        }

        return true;

    }
}
