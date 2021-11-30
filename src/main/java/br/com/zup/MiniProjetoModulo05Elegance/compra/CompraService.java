package br.com.zup.MiniProjetoModulo05Elegance.compra;

import br.com.zup.MiniProjetoModulo05Elegance.cliente.ClienteRepositoy;
import br.com.zup.MiniProjetoModulo05Elegance.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private CompraRepository compraRepository;
    private ClienteRepositoy clienteRepositoy;
    private ProdutoRepository produtoRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository, ClienteRepositoy clienteRepositoy, ProdutoRepository produtoRepository) {
        this.compraRepository = compraRepository;
        this.clienteRepositoy = clienteRepositoy;
        this.produtoRepository = produtoRepository;
    }

    public Compra realizarCompra (Compra compra){
        return compraRepository.save(compra);
    }
}
