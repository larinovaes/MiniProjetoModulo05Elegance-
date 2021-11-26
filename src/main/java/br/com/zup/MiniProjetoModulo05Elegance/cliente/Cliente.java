package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
