package br.com.regissanme.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 11:19
 */
@Getter
@Setter
public class OcorrenciaInput {

    @NotBlank
    private String descricao;
}
