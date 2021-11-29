package br.com.zup.MiniProjetoModulo05Elegance.exeption;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MensagemErro {
    private String mensagem;
    private String campo;

    public MensagemErro(String mensagem, String campo) {
        this.mensagem = mensagem;
        this.campo = campo;
    }
}