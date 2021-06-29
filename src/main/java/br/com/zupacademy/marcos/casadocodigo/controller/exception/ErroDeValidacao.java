package br.com.zupacademy.marcos.casadocodigo.controller.exception;

public class ErroDeValidacao {

    private String campo;

    private String mensagem;

    public ErroDeValidacao(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
