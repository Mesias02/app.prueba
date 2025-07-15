package com.example.app.prueba.mapper;

@Mapper(componentModel = "spring")
public interface LeadMapper {
    LeadDto toDTO(Lead lead);
    Lead toEntity(LeadDto leadDTO);
}
