package com.takeaway.restaurant.domain.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<ENTITY, DTO> {

    ENTITY mapToEntity(ENTITY entity, DTO dto);
    DTO mapToDto(ENTITY value, DTO dto);

}
