package br.com.regissanme.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 10:05
 */
@Getter
@Setter
public class EntregaInput {

    @Valid
    @NotNull
    private ClienteInputId cliente;

    @Valid
    @NotNull
    private DestinarioInput destinatario;

    @NotNull
    private BigDecimal taxa;

}
