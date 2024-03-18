package one.digitalinnovation.desafiodiocepapi.service.impl;

import one.digitalinnovation.desafiodiocepapi.model.Endereco;
import one.digitalinnovation.desafiodiocepapi.repository.EnderecoRepository;
import one.digitalinnovation.desafiodiocepapi.service.EnderecoService;
import one.digitalinnovation.desafiodiocepapi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Endereco> buscarTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarEnderecoPorId(String cep) {
        Optional<Endereco> endereco = enderecoRepository.findById(cep);
        return endereco.orElse(null);
    }

    @Override
    public Endereco inserirEndereco(String cep) {
        Endereco novoEndereco = viaCepService.consultarCep(cep);
        novoEndereco.setGoogleMaps(cep);
        enderecoRepository.save(novoEndereco);
        return novoEndereco;
    }

    @Override
    public void atualizarEndereco(String cep, Endereco endereco) {
        Optional<Endereco> enderecoBd = enderecoRepository.findById(cep);
        if (enderecoBd.isPresent()) {
            enderecoRepository.save(endereco);
        }
    }

    @Override
    public void deletarEndereco(String cep) {
        enderecoRepository.deleteById(cep);
    }
}
