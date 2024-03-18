package one.digitalinnovation.desafiodiocepapi.service;

import one.digitalinnovation.desafiodiocepapi.model.Cliente;
import one.digitalinnovation.desafiodiocepapi.model.Endereco;

public interface EnderecoService {

    Iterable<Endereco> buscarTodosEnderecos();

    Endereco buscarEnderecoPorId(String cep);

    Endereco inserirEndereco(String cep);

    void atualizarEndereco(String cep, Endereco endereco);

    void deletarEndereco(String cep);
}
