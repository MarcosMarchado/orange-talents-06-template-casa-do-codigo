package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/*Valida se:
* 1- Se o País tiver estados e não for passado estado na requisição retornará erro
* 2- Se o Pais tiver estados e o Estado passado não for encontrado retornará tbm um erro*/
@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EstadoPaisValidator.class)
public @interface EstadoPais {
    String message() default "Estado inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
