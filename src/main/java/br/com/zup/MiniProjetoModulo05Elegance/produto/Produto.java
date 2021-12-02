package br.com.zup.MiniProjetoModulo05Elegance.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "produtos")

@NoArgsConstructor
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoDoProduto;
    private String nomeDoProduto;
    private Double valorDoProduto;
    private Integer quantidadeDeProduto;

}
