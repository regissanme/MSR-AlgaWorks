package br.com.regissanme.log.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 09:05
 */
@Getter
@Setter
public class DestinatarioModel {

    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
}
