package br.com.zup.MiniProjetoModulo05Elegance.produto;

import br.com.zup.MiniProjetoModulo05Elegance.exception.ClienteNaoEncontrado;
import br.com.zup.MiniProjetoModulo05Elegance.exception.EmailJaCadastrado;
import br.com.zup.MiniProjetoModulo05Elegance.exception.EsseProdutoJaFoiDeletado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastoProduto(Produto produto) {
        validarProduto(produto.getNomeDoProduto());
        produtoRepository.save(produto);
        return produto;
    }

    public List<Produto> exibirListaDeProdutos() {
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
        return produtos;
    }

    public Produto produtoEspecifico(Integer codigoDoProduto) {
        for (Produto referencia : produtoRepository.findAll()) {
            if (referencia.getCodigoDoProduto().equals(codigoDoProduto)) {
                return referencia;
            }
        }
        throw new ClienteNaoEncontrado("Cliente Não encontrado");
    }


    public void deletarProduto(Integer codigoDoProduto) {
        if (!produtoRepository.existsById(codigoDoProduto)) {
            throw new EsseProdutoJaFoiDeletado("Esse produto já foi deletado");
        }
        produtoRepository.deleteById(codigoDoProduto);
    }

    public void validarProduto(String nomeDoProduto) {
        if (produtoRepository.countByNomeDoProduto(nomeDoProduto) > 0) {
            throw new EmailJaCadastrado("Esse produto já está cadastrado");
        }
    }
}
