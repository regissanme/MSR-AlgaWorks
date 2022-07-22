package br.com.regissanme.log.domain.repository;

import br.com.regissanme.log.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 22/07/2022
 * Hora: 16:22
 */
@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
