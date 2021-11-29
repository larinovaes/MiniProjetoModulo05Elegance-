package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoy clienteRepositoy;

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepositoy.save(cliente);
    }


}
