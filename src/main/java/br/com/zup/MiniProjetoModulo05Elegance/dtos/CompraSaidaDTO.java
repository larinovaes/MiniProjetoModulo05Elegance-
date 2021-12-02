package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class CompraSaidaDTO {
    private Integer numeroDoPedido;
    private ClienteSaidaDTO cliente;
    private List<Produto> produtos;
    private Double valor;
    private LocalDate dataDeCompra = LocalDate.now();
}
