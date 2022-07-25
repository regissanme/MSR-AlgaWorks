package br.com.regissanme.log.api.controller;

import br.com.regissanme.log.api.mapper.EntregaMapper;
import br.com.regissanme.log.api.model.DestinatarioModel;
import br.com.regissanme.log.api.model.EntregaModel;
import br.com.regissanme.log.api.model.input.EntregaInput;
import br.com.regissanme.log.domain.model.Entrega;
import br.com.regissanme.log.domain.repository.EntregaRepository;
import br.com.regissanme.log.domain.service.EntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private EntregaMapper entregaMapper;

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaMapper.toCollectionModel(entregaService.listar());
    }

    @PostMapping
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
        return entregaMapper.toModel(entregaService.solicitar(entregaMapper.toEntity(entregaInput)));
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscarPorId(@PathVariable Long entregaId) {

        return entregaService.buscarPorId(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }


}
