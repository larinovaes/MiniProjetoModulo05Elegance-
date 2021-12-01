package br.com.zup.MiniProjetoModulo05Elegance.exception;

public class CpfJaCadastrado extends RuntimeException{

    public CpfJaCadastrado(String message) {
        super(message);
    }
}
