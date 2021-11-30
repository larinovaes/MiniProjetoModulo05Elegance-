package br.com.zup.MiniProjetoModulo05Elegance.produto;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    List<Produto> findAllByCodigoDoProduto(Integer codigoDoProduto);
}