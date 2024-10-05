package com.incetutku.organizationservice.service.impl;

import com.incetutku.organizationservice.dto.OrganizationDto;
import com.incetutku.organizationservice.entity.Organization;
import com.incetutku.organizationservice.mapper.OrganizationMapper;
import com.incetutku.organizationservice.repository.OrganizationRepository;
import com.incetutku.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getByCode(String code) {
        Optional<Organization> optionalOrganization = organizationRepository.findByCode(code);
        return optionalOrganization.map(OrganizationMapper::mapToOrganizationDto).orElse(null);
    }
}
