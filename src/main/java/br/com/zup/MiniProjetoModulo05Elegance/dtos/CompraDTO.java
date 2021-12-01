package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import br.com.zup.MiniProjetoModulo05Elegance.cliente.Cliente;
import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private Cliente cliente;
    private List<Produto> produtos;
   // private Double valor;
  //  private LocalDateTime dataDeCompra;

}
