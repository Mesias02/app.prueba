package com.example.app.prueba.mapper;

import com.example.app.prueba.dto.LeadDto;

@Mapper(componentModel = "spring")
public interface LeadMapper {
    LeadDto toDTO(Lead lead);
    Lead toEntity(LeadDto leadDTO);
}
