package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter

public class ProdutoDTO {
    private Integer codigoDoProduto;
    @NotBlank
    @Size(max = 100, min = 3)
    private String nomeDoProduto;
    @NotNull
    private Double valorDoProduto;
    @NotNull
    private Integer quantidadeDeProduto;
}
