package br.com.regissanme.log.domain.repository;

import br.com.regissanme.log.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 21/07/2022
 * Hora: 16:00
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByNomeContaining(String nome);
    public Optional<Cliente> findByEmail(String email);
}
