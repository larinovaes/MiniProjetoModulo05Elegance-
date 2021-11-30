package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import br.com.zup.MiniProjetoModulo05Elegance.exception.PesquisarEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoy clienteRepositoy;

    public Cliente salvarCliente(Cliente cliente) {
        Cliente cliente1 = pesquisarEmailRepetido(cliente);
        return clienteRepositoy.save(cliente);
    }

    public Cliente pesquisarEmailRepetido(Cliente cliente) {
        for (Cliente clienteReferencia : clienteRepositoy.findAll()) {
            if (clienteReferencia.getEmail().equalsIgnoreCase(cliente.getEmail())) {
                throw new PesquisarEmailException("Esse email ja possui cadastro em nosso banco!");
            }
        }
        return clienteRepositoy.save(cliente);
    }


}
