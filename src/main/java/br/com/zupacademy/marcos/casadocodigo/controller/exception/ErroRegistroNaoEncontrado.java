package br.com.zupacademy.marcos.casadocodigo.controller.exception;

public class ErroRegistroNaoEncontrado {
    private Integer status;
    private String mensagem;

    public ErroRegistroNaoEncontrado(Integer status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

}
