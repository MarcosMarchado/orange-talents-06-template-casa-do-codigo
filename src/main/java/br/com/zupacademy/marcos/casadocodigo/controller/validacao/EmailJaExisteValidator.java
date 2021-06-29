package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import br.com.zupacademy.marcos.casadocodigo.model.Autor;
import br.com.zupacademy.marcos.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailJaExisteValidator implements ConstraintValidator<EmailJaExiste, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailJaExiste constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Autor autor = autorRepository.findByEmail(email);
        if(autor != null){
            return false;
        }
        return true;
    }
}
