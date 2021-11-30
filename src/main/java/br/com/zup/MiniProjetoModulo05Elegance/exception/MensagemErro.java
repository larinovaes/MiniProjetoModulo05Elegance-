package br.com.zup.MiniProjetoModulo05Elegance.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MensagemErro {
    private String mensagem;

    public MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }
}
