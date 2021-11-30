package br.com.zup.MiniProjetoModulo05Elegance.exception;

public class ClienteNaoEncontrado extends RuntimeException {

    public ClienteNaoEncontrado(String message) {
        super(message);
    }
}
