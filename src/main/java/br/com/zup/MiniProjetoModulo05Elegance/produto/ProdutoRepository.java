package br.com.zup.MiniProjetoModulo05Elegance.produto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {


    Produto findAllByCodigoDoProduto(Integer codigoDoProduto);

    boolean existsByCodigoDoProduto(Integer codigoDoProduto);

    boolean existsByNomeDoProduto(String nomeDoProduto);

    Produto findByNomeDoProduto(String nomeDoProduto);

    Integer countByNomeDoProduto(String nomeDoProduto);
}