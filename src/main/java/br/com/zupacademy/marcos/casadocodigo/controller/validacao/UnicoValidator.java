package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import br.com.zupacademy.marcos.casadocodigo.model.Autor;
import br.com.zupacademy.marcos.casadocodigo.model.Categoria;
import br.com.zupacademy.marcos.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcos.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UnicoValidator implements ConstraintValidator<Unico, String> {

    @Autowired
    private EntityManager entityManager;

    private Class<?> clazz;

    private String fieldName;

    @Override
    public void initialize(Unico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.fieldName = constraintAnnotation.fieldName();
        this.clazz = constraintAnnotation.clazz();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String JPQL = "SELECT c FROM "
                + clazz.getName() +
                " c WHERE c." + fieldName + " = :pValor";

        Query query = entityManager.createQuery(JPQL);
        query.setParameter("pValor", value);
        boolean valido = query.getResultList().isEmpty();;
        return valido;
    }
}
