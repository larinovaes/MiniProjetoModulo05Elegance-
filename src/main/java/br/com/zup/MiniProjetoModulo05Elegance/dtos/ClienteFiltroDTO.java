package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ClienteFiltroDTO {
    private String nome;
    private String cpf;
    private String telefone;

}
