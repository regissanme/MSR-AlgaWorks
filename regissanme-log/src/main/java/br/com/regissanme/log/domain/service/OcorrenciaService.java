package br.com.regissanme.log.domain.service;

import br.com.regissanme.log.domain.model.Entrega;
import br.com.regissanme.log.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 11:02
 */
@Service
@AllArgsConstructor
public class OcorrenciaService {

    private EntregaService entregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = entregaService.buscarPorId(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }

    public List<Ocorrencia> findAllByEntrega(Long entregaId) {
        Entrega entrega = entregaService.buscarPorId(entregaId);

        return entrega.getOcorrencias();
    }
}
