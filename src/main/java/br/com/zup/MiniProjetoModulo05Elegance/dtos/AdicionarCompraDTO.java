package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AdicionarCompraDTO {
    private String cpf;
    private Integer numeroDoPedido;
}
