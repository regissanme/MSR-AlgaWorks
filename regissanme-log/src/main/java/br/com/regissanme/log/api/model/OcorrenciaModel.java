package br.com.regissanme.log.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 11:16
 */
@Getter
@Setter
public class OcorrenciaModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
