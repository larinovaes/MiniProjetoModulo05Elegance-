package br.com.zup.MiniProjetoModulo05Elegance.cliente.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter

public class ClienteDto {
    @CPF
    private String cpf;
    @NotNull
    @Size(min = 2, max = 20, message = "Favor digitar um nome entre 2 a 20 caracteres")
    private String nome;
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;

}
