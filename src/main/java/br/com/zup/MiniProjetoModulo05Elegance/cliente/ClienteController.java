package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import br.com.zup.MiniProjetoModulo05Elegance.cliente.dto.ClienteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ClienteDto cadastrarCliente(@RequestBody @Valid ClienteDto cliente) {
        Cliente novoCliente = modelMapper.map(cliente, Cliente.class);
        return modelMapper.map(clienteService.salvarCliente(novoCliente), ClienteDto.class);
    }

}
