package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoy extends CrudRepository<Cliente, String> {
    Cliente findByCpf(String cpf);

    boolean existsByCpf(String cpf);

    Cliente findByNome(String nome);

    Integer countByEmail(String email);
}
