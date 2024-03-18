package one.digitalinnovation.desafiodiocepapi.repository;

import one.digitalinnovation.desafiodiocepapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
