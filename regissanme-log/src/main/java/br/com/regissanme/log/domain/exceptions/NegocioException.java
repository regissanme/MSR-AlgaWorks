package br.com.regissanme.log.domain.exceptions;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 22/07/2022
 * Hora: 11:37
 */
public class NegocioException extends RuntimeException {

    public NegocioException(String message) {
        super(message);
    }
}
