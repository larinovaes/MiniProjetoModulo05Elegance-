package br.com.zup.MiniProjetoModulo05Elegance.produto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    boolean existsByNomeDoProduto(String nomeDoProduto);

    Produto findByNomeDoProduto(String nomeDoProduto);

    Integer countByNomeDoProduto(String nomeDoProduto);
}