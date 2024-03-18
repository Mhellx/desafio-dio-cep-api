package one.digitalinnovation.desafiodiocepapi.repository;

import one.digitalinnovation.desafiodiocepapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
