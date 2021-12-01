package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import br.com.zup.MiniProjetoModulo05Elegance.compra.Compra;
import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")

@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    @Column(unique = true)
    private String email;
    private String telefone;
    private String endereco;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Compra> compras;

}
