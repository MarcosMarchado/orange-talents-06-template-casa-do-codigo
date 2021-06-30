package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import br.com.zupacademy.marcos.casadocodigo.model.Categoria;
import br.com.zupacademy.marcos.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoriaJaExisteValidator implements ConstraintValidator<CategoriaJaExiste, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(CategoriaJaExiste constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nomeCategoria, ConstraintValidatorContext context) {
        Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
        if(categoria != null){
            return false;
        }
        return true;
    }
}
