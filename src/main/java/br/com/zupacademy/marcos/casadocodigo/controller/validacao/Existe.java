package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/*Valida se existe o objeto existe de acordo com id passado*/
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ExisteValidator.class)
public @interface Existe {
    String message() default "Registro não encontrado";
    String fieldName();
    Class<?> clazz();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
