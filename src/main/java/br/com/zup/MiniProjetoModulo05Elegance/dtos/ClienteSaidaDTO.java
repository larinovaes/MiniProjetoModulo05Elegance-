package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ClienteSaidaDTO {
    private String cpf;
    private String nome;
    private String telefone;

}
