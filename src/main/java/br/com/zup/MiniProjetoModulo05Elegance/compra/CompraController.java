package br.com.zup.MiniProjetoModulo05Elegance.compra;

import br.com.zup.MiniProjetoModulo05Elegance.cliente.Cliente;
import br.com.zup.MiniProjetoModulo05Elegance.dtos.AdicionarCompraDTO;
import br.com.zup.MiniProjetoModulo05Elegance.dtos.ClienteFiltroDTO;
import br.com.zup.MiniProjetoModulo05Elegance.dtos.CompraDTO;
import br.com.zup.MiniProjetoModulo05Elegance.dtos.CompraSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    CompraService compraService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraSaidaDTO realizarCompra(@RequestBody CompraSaidaDTO compraSaidaDTO) {
        Compra compra = modelMapper.map(compraSaidaDTO, Compra.class);
        compraService.salvarCompra(compra);
        compraSaidaDTO = modelMapper.map(compra, CompraSaidaDTO.class);
        return compraSaidaDTO;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarCompraAoCliente(@RequestBody AdicionarCompraDTO adicionarCompraDTO) {
        compraService.adicionarCompraAoCliente(adicionarCompraDTO.getCpf(), adicionarCompraDTO.getNumeroDoPedido());
    }
    @GetMapping
    public List<CompraSaidaDTO> exibirListaDeCompras() {
        List<CompraSaidaDTO> listarCompras = new ArrayList<>();
        for (Compra compra : compraService.listarCompras()) {
            CompraSaidaDTO compraSaidaDTO = modelMapper.map(compra, CompraSaidaDTO.class);
            listarCompras.add(compraSaidaDTO);
        }
        return listarCompras;
    }

    @GetMapping("/{numeroDoPedido}")
    public CompraSaidaDTO exibirCompraEspecifica(@PathVariable Integer numeroDoPedido) {
        Compra compra = compraService.exibirCompraEspecifica(numeroDoPedido);
        return modelMapper.map(compra, CompraSaidaDTO.class);
    }
}
