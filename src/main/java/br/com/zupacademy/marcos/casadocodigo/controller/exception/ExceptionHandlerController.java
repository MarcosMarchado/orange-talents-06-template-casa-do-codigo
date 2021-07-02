package br.com.zupacademy.marcos.casadocodigo.controller.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeValidacao> MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ErroDeValidacao> erros = new ArrayList<>();

        exception.getGlobalErrors().forEach(objectError -> {
            erros.add(new ErroDeValidacao(objectError.getObjectName(), objectError.getDefaultMessage()));
        });

        exception.getFieldErrors().forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErroDeValidacao erroDeValidacao = new ErroDeValidacao(fieldError.getField(), mensagem);
            erros.add(erroDeValidacao);
        });
        return erros;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ErroRegistroNaoEncontrado ObjectNotFoundException(ObjectNotFoundException exception){
        return new ErroRegistroNaoEncontrado(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

}
