package br.com.zup.MiniProjetoModulo05Elegance.compra;

import br.com.zup.MiniProjetoModulo05Elegance.dtos.CompraDTO;
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

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraDTO realizarCompra(@RequestBody CompraDTO compraDTO) {
        Compra compra = modelMapper.map(compraDTO, Compra.class);
        compraService.salvarCompra(compra);
        compraDTO = modelMapper.map(compra, CompraDTO.class);
        return compraDTO;
 
    }

}
