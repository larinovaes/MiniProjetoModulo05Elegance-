package br.com.zup.MiniProjetoModulo05Elegance.compra;

import br.com.zup.MiniProjetoModulo05Elegance.cliente.Cliente;
import br.com.zup.MiniProjetoModulo05Elegance.cliente.ClienteRepositoy;
import br.com.zup.MiniProjetoModulo05Elegance.cliente.ClienteService;
import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;
import br.com.zup.MiniProjetoModulo05Elegance.produto.ProdutoRepository;
import br.com.zup.MiniProjetoModulo05Elegance.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompraService {

    private CompraRepository compraRepository;

    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepositoy clienteRepositoy;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;


    @Autowired
    public CompraService(CompraRepository compraRepository, ProdutoRepository produtoRepository) {
        this.compraRepository = compraRepository;
        this.produtoRepository = produtoRepository;

    }

    public Compra salvarCompra(Compra compra) {
        Cliente clientes = clienteService.buscarClienteporCpf(compra.getCliente().getCpf());
        compra.setCliente(clientes);

        List<Produto> produtos = buscarProdutos(compra.getProdutos());
        compra.setProdutos(produtos);
        return compraRepository.save(compra);
    }


    private List<Produto> buscarProdutos(List<Produto> produtos) {

        List<Produto> listaAtualizada = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produtoRepository.existsByNomeDoProduto(produto.getNomeDoProduto())) {
                listaAtualizada.add(produtoRepository.findByNomeDoProduto(produto.getNomeDoProduto()));
            }else {
                listaAtualizada.add(produto);
            }
        }

        return listaAtualizada;
    }




}






