package br.com.regissanme.log.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 09:28
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
