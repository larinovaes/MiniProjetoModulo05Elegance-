package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {
    private String nomeDoProduto;
    private Double valorDoProduto;
    private Integer quantidadeDeProduto;
}
