package br.com.zup.MiniProjetoModulo05Elegance.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastoProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }
}
