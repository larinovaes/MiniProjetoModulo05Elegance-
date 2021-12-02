package br.com.zup.MiniProjetoModulo05Elegance.compra;

import br.com.zup.MiniProjetoModulo05Elegance.dtos.AdicionarCompraDTO;
import br.com.zup.MiniProjetoModulo05Elegance.dtos.CompraDTO;
import br.com.zup.MiniProjetoModulo05Elegance.dtos.CompraSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public AdicionarCompraDTO adicionarCompraAoCliente(@RequestBody AdicionarCompraDTO adicionarCompraDTO) {
        Compra compra = modelMapper.map(adicionarCompraDTO, Compra.class);
        compraService.adicionarCompraAoCliente(adicionarCompraDTO.getCpf(), adicionarCompraDTO.getNumeroDoPedido());
        return adicionarCompraDTO;
    }
}
