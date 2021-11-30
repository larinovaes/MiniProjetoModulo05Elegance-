package br.com.zup.MiniProjetoModulo05Elegance.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastoProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public List<Produto> exibirListaDeProdutos() {
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
        return produtos;
    }

    public Produto produtoEspecifico(Integer codigoDoProduto) {
        for (Produto referencia:produtoRepository.findAll()) {
            if (referencia.getCodigoDoProduto().equals(codigoDoProduto)) {
                return referencia;
            }
        }
        throw new RuntimeException("Não existe");
    }

    public void deletarProduto(Integer codigoDoProduto) {
        if (produtoRepository.existsById(codigoDoProduto)) {
            produtoRepository.deleteById(codigoDoProduto);
        }
    }
}
