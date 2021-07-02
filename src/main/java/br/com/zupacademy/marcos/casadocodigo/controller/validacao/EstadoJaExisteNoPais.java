package br.com.zupacademy.marcos.casadocodigo.controller.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EstadoJaExisteNoPaisValidator.class)
public @interface EstadoJaExisteNoPais {
    String message() default "Estado já cadastrado neste País";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
