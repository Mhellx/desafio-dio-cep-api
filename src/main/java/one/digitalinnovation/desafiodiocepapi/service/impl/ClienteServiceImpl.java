package one.digitalinnovation.desafiodiocepapi.service.impl;

import one.digitalinnovation.desafiodiocepapi.model.Cliente;
import one.digitalinnovation.desafiodiocepapi.repository.ClienteRepository;
import one.digitalinnovation.desafiodiocepapi.model.Endereco;
import one.digitalinnovation.desafiodiocepapi.repository.EnderecoRepository;
import one.digitalinnovation.desafiodiocepapi.service.ClienteService;
import one.digitalinnovation.desafiodiocepapi.service.EnderecoService;
import one.digitalinnovation.desafiodiocepapi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodosClientes() {
        // Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizarCliente(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletarCliente(Long id) {
        // Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoService.buscarEnderecoPorId(cep);
        if(endereco == null) {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            endereco = enderecoService.inserirEndereco(cep);
        }
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }
}
