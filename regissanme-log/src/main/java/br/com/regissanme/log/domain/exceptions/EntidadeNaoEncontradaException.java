package br.com.regissanme.log.domain.exceptions;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 11:40
 */
public class EntidadeNaoEncontradaException extends NegocioException {


    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
