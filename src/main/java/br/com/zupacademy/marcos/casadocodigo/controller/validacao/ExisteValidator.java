package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExisteValidator implements ConstraintValidator<Existe, Object> {

    private Class<?> clazz;
    private String fieldName;
    @Autowired
    private EntityManager entityManager;

    @Override
    public void initialize(Existe constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.clazz = constraintAnnotation.clazz();
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String JPQL = "SELECT c FROM "
                + clazz.getName()+
                " c WHERE c."+fieldName+" = :pId";
        Query query = entityManager.createQuery(JPQL);
        query.setParameter("pId", value);
        boolean valido = !query.getResultList().isEmpty();
        return valido;
    }
}
