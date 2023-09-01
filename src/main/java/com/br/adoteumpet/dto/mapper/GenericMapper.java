package com.br.adoteumpet.dto.mapper;

import java.util.List;

public interface GenericMapper<E, DTO> {

    DTO entityToDTO(E entity);
    E dtoToEntity(DTO dto);
    List<DTO> entityListToDtoList(List<E> listEntity);
    List<DTO> dtoListToEntityList(List<DTO> listDto);

}
