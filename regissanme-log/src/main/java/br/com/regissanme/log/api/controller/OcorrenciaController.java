package br.com.regissanme.log.api.controller;

import br.com.regissanme.log.api.mapper.OcorrenciaMapper;
import br.com.regissanme.log.api.model.OcorrenciaModel;
import br.com.regissanme.log.api.model.input.OcorrenciaInput;
import br.com.regissanme.log.domain.model.Entrega;
import br.com.regissanme.log.domain.service.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 11:24
 */
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
@AllArgsConstructor
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;

    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable @NotNull Long entregaId,
                                     @RequestBody @Valid OcorrenciaInput ocorrenciaInput) {
        return ocorrenciaMapper.toModel(ocorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao()));
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        return ocorrenciaMapper.toCollectionModel(ocorrenciaService.findAllByEntrega(entregaId));
    }
}
