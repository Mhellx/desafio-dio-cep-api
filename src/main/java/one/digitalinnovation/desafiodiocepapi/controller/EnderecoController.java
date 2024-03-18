package one.digitalinnovation.desafiodiocepapi.controller;

import one.digitalinnovation.desafiodiocepapi.model.Cliente;
import one.digitalinnovation.desafiodiocepapi.model.Endereco;
import one.digitalinnovation.desafiodiocepapi.repository.EnderecoRepository;
import one.digitalinnovation.desafiodiocepapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<Iterable<Endereco>> buscarTodos() {
        return ResponseEntity.ok(enderecoService.buscarTodosEnderecos());
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable String cep) {
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(cep));
    }

    @PostMapping
    public ResponseEntity<Endereco> inserir(@RequestBody String cep) {
        Endereco endereco = enderecoService.inserirEndereco(cep);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{cep}")
    public ResponseEntity<Endereco> atualizar(@PathVariable String cep, @RequestBody Endereco endereco) {
        enderecoService.atualizarEndereco(cep, endereco);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{cep}")
    public ResponseEntity<Void> deletar(@PathVariable String cep) {
        enderecoService.deletarEndereco(cep);
        return ResponseEntity.ok().build();
    }
}
