package br.com.regissanme.log.domain.service;

import br.com.regissanme.log.domain.exceptions.NegocioException;
import br.com.regissanme.log.domain.model.Cliente;
import br.com.regissanme.log.domain.model.Entrega;
import br.com.regissanme.log.domain.model.StatusEntrega;
import br.com.regissanme.log.domain.repository.ClienteRepository;
import br.com.regissanme.log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
        Cliente cliente = clienteService.buscarPorId(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setDataPedido(LocalDateTime.now());
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);

        return entregaRepository.save(entrega);
    }

}
