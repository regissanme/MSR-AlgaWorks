package br.com.regissanme.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 10:08
 */
@Getter
@Setter
public class ClienteInputId {

    @NotNull
    private Long id;
}
