package br.com.regissanme.log.api.controller;

import br.com.regissanme.log.domain.model.Entrega;
import br.com.regissanme.log.domain.repository.EntregaRepository;
import br.com.regissanme.log.domain.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<Entrega> listar(){
        return entregaService.listar();
    }

    @PostMapping
    public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
        return entregaService.solicitar(entrega);
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Long entregaId) {
        Optional<Entrega> optEntrega = entregaService.buscarPorId(entregaId);
        return optEntrega.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
