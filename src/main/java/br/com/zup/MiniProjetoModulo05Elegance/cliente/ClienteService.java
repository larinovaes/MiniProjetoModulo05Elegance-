package br.com.zup.MiniProjetoModulo05Elegance.cliente;

import br.com.zup.MiniProjetoModulo05Elegance.exception.CpfJaCadastrado;
import br.com.zup.MiniProjetoModulo05Elegance.exception.EmailJaCadastrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoy clienteRepositoy;

    public Cliente salvarCliente(Cliente cliente) {
        validarEmail(cliente.getEmail());
        validarCpf(cliente.getCpf());
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

    public void validarEmail(String email) {
        if (clienteRepositoy.countByEmail(email) > 0) {
            throw new EmailJaCadastrado("Email já cadastrado");
        }
    }

    public void validarCpf(String cpf) {
        if (clienteRepositoy.existsById(cpf)) {
            throw new CpfJaCadastrado("CPF já cadastrado");
        }
    }
}
