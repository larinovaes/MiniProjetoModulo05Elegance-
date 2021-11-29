package br.com.zup.MiniProjetoModulo05Elegance.cliente.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class ClienteDto {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

}
