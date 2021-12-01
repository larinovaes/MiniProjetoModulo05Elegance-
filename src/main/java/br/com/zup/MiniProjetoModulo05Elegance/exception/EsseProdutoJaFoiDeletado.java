package br.com.zup.MiniProjetoModulo05Elegance.exception;

public class EsseProdutoJaFoiDeletado extends RuntimeException{

    public EsseProdutoJaFoiDeletado(String message) {
        super(message);
    }
}
