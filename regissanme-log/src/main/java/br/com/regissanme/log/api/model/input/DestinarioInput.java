package br.com.regissanme.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 10:10
 */
@Getter
@Setter
public class DestinarioInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;
}
