package br.com.regissanme.log.api.controller;

import br.com.regissanme.log.domain.model.Entrega;
import br.com.regissanme.log.domain.repository.EntregaRepository;
import br.com.regissanme.log.domain.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 22/07/2022
 * Hora: 16:36
 */
@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaService entregaService;

    @PostMapping
    public Entrega solicitar(@RequestBody Entrega entrega) {
        return entregaService.solicitar(entrega);
    }

}
