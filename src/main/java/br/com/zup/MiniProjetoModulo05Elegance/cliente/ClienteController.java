package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import br.com.zup.MiniProjetoModulo05Elegance.dtos.ClienteDTO;
import br.com.zup.MiniProjetoModulo05Elegance.dtos.ClienteFiltroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO cadastrarCliente(@RequestBody @Valid ClienteDTO cliente) {
        Cliente novoCliente = modelMapper.map(cliente, Cliente.class);
        return modelMapper.map(clienteService.salvarCliente(novoCliente), ClienteDTO.class);
    }

    @GetMapping
    public List<ClienteFiltroDTO> exibirClientes() {
        List<ClienteFiltroDTO> listaDeClientes = new ArrayList<>();
        for (Cliente clienteReferencia : clienteService.exibirCliente()) {
            ClienteFiltroDTO clienteFiltro = modelMapper.map(clienteReferencia, ClienteFiltroDTO.class);
            listaDeClientes.add(clienteFiltro);
        }
        return listaDeClientes;
    }

    @GetMapping("/{cpf}")
    public ClienteFiltroDTO exibirClientePorCpf(@PathVariable String cpf) {
        Cliente clientes = clienteService.buscarClienteporCpf(cpf);
        return modelMapper.map(clientes, ClienteFiltroDTO.class);
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCpf(@PathVariable String cpf) {
        clienteService.deletarCliente(cpf);


    }
}

