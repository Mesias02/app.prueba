package com.example.app.prueba.service;

import com.example.app.prueba.dto.LeadDto;
import com.example.app.prueba.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;

    public LeadDto getLeadById(Long id) {
        Lead lead = leadRepository.findById(id).orElseThrow(() -> new RuntimeException("Lead not found"));
        return mapToDTO(lead);
    }

    public List<LeadDto> getAllLeads() {
        return leadRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public LeadDto createLead(LeadDto leadDTO) {
        Lead lead = new Lead();
        lead.setName(leadDTO.getName());
        lead.setEmail(leadDTO.getEmail());
        lead.setPhone(leadDTO.getPhone());
        lead.setStatus(leadDTO.getStatus());
        lead = leadRepository.save(lead);
        return mapToDTO(lead);
    }

    private LeadDto mapToDTO(Lead lead) {
        LeadDto dto = new LeadDto();
        dto.setId(lead.getId());
        dto.setName(lead.getName());
        dto.setEmail(lead.getEmail());
        dto.setPhone(lead.getPhone());
        dto.setStatus(lead.getStatus());
        return dto;
    }
}
