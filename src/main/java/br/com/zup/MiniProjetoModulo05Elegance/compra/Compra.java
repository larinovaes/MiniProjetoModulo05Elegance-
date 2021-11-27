package br.com.zup.MiniProjetoModulo05Elegance.compra;

import br.com.zup.MiniProjetoModulo05Elegance.cliente.Cliente;
import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroDoPedido;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    private List<Produto> produtos;
    private Double valor;
    private LocalDateTime dataDeCompra;

}
