package br.com.zup.MiniProjetoModulo05Elegance.dtos;

import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer valorTotal;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate dataDeCompra = LocalDate.now();
}
