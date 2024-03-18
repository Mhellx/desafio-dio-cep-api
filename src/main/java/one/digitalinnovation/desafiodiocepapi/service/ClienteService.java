package one.digitalinnovation.desafiodiocepapi.service;

import one.digitalinnovation.desafiodiocepapi.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodosClientes();

    Cliente buscarClientePorId(Long id);

    void inserirCliente(Cliente cliente);

    void atualizarCliente(Long id, Cliente cliente);

    void deletarCliente(Long id);
}
