package br.com.regissanme.log.api.mapper;

import br.com.regissanme.log.api.model.EntregaModel;
import br.com.regissanme.log.api.model.input.EntregaInput;
import br.com.regissanme.log.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 25/07/2022
 * Hora: 09:38
 */
@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream().map(this::toModel).collect(Collectors.toList());
    }
}
