package br.com.zup.MiniProjetoModulo05Elegance.compra;

import br.com.zup.MiniProjetoModulo05Elegance.cliente.Cliente;
import br.com.zup.MiniProjetoModulo05Elegance.cliente.ClienteRepositoy;
import br.com.zup.MiniProjetoModulo05Elegance.cliente.ClienteService;
import br.com.zup.MiniProjetoModulo05Elegance.exception.CompraNaoEncontrada;
import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;
import br.com.zup.MiniProjetoModulo05Elegance.produto.ProdutoRepository;
import br.com.zup.MiniProjetoModulo05Elegance.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CompraService {

    private CompraRepository compraRepository;
    private ProdutoRepository produtoRepository;
    private ClienteRepositoy clienteRepositoy;
    private ClienteService clienteService;
    private ProdutoService produtoService;


    @Autowired
    public CompraService(CompraRepository compraRepository, ProdutoRepository produtoRepository,
                         ClienteRepositoy clienteRepositoy, ClienteService clienteService,
                         ProdutoService produtoService) {
        this.compraRepository = compraRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepositoy = clienteRepositoy;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public Compra salvarCompra(Compra compra) {
        Cliente clientes = clienteService.buscarClienteporCpf(compra.getCliente().getCpf());
        compra.setCliente(clientes);
        compra.setValor(calcularValorTotal(compra.getProdutos()));
        return compraRepository.save(compra);
    }

    public Double calcularValorTotal(List<Produto> produtos) {
        return produtos.stream().collect(Collectors.summingDouble(produto -> produto.getValorDoProduto() *
                produto.getQuantidadeDeProduto()));
    }

    private List<Produto> buscarProdutos(List<Produto> produtos) {

        List<Produto> listaAtualizada = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produtoRepository.existsByNomeDoProduto(produto.getNomeDoProduto())) {
                listaAtualizada.add(produtoRepository.findByNomeDoProduto(produto.getNomeDoProduto()));
            } else {
                listaAtualizada.add(produto);
            }
        }

        return listaAtualizada;
    }

    public void adicionarCompraAoCliente(String cpf, Integer pedido) {
        Cliente cliente = clienteRepositoy.findByCpf(cpf);
        Optional<Compra> compra = compraRepository.findById(pedido);

        if (compra.isPresent()) {
            cliente.getCompras().add(compra.get());
            clienteRepositoy.save(cliente);
        }

    }

    public List<Compra> listarCompras() {
        List<Compra> compras = (List<Compra>) compraRepository.findAll();
        return compras;
    }

    public Compra exibirCompraEspecifica(Integer numeroDoPedido) {
        for (Compra compra : compraRepository.findAll()) {
            if (compra.getNumeroDoPedido().equals(numeroDoPedido)) {
                return compra;
            }
        }
        throw new CompraNaoEncontrada("Compra não encontrada");
    }

    public void deletarCompra(Integer numeroDoPedido) {
        if (!compraRepository.existsById(numeroDoPedido)) {
            throw new CompraNaoEncontrada("compra não existe!");
        }
        compraRepository.deleteById(numeroDoPedido);
    }

}
