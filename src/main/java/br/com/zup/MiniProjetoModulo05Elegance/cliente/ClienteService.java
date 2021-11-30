package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import br.com.zup.MiniProjetoModulo05Elegance.exception.PesquisarCpfException;
import br.com.zup.MiniProjetoModulo05Elegance.exception.PesquisarEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoy clienteRepositoy;

    public Cliente salvarCliente(Cliente cliente) {
        Cliente cliente1 = pesquisarEmailRepetido(cliente);
        return clienteRepositoy.save(cliente);
    }

    public List<Cliente> exibirCliente() {
        Iterable<Cliente> listaDeClientes = clienteRepositoy.findAll();
        return (List<Cliente>) listaDeClientes;
    }

    public Cliente buscarClienteporCpf(String cpf) {
        Optional<Cliente> clienteCpf = Optional.ofNullable(clienteRepositoy.findByCpf(cpf));
        return clienteCpf.get();
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
