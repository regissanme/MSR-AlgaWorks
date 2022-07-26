package br.com.regissanme.log.domain.service;

import br.com.regissanme.log.domain.exceptions.EntidadeNaoEncontradaException;
import br.com.regissanme.log.domain.exceptions.NegocioException;
import br.com.regissanme.log.domain.model.Cliente;
import br.com.regissanme.log.domain.model.Entrega;
import br.com.regissanme.log.domain.model.StatusEntrega;
import br.com.regissanme.log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 22/07/2022
 * Hora: 16:23
 */
@Service
@AllArgsConstructor
public class EntregaService {

    private EntregaRepository entregaRepository;
    private ClienteService clienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = clienteService.buscarPorId(entrega.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrdo!"));

        entrega.setCliente(cliente);
        entrega.setDataPedido(OffsetDateTime.now());
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);

        return entregaRepository.save(entrega);
    }

    public List<Entrega> listar() {
        return entregaRepository.findAll();
    }

    public Entrega buscarPorId(Long id) {
        return entregaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não Encontrada!"));
    }

    public void finalizarEntrega(Long entregaId) {
        Entrega entrega = buscarPorId(entregaId);
        entrega.finalizar();

        entregaRepository.save(entrega);
    }

}
