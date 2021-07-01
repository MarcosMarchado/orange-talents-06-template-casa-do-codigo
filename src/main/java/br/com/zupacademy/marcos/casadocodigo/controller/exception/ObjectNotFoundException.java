package br.com.zupacademy.marcos.casadocodigo.controller.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
