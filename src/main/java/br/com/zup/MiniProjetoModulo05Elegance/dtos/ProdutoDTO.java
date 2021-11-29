package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {
    @NotBlank
    private String nomeDoProduto;
    @NotNull
    private Double valorDoProduto;
    @NotNull
    private Integer quantidadeDeProduto;
}
