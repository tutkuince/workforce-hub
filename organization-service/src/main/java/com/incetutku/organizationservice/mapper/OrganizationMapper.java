package com.incetutku.organizationservice.mapper;

import com.incetutku.organizationservice.dto.OrganizationDto;
import com.incetutku.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        return Organization.builder()
                .id(organizationDto.getId())
                .name(organizationDto.getName())
                .description(organizationDto.getDescription())
                .code(organizationDto.getCode())
                .createdDate(organizationDto.getCreatedDate())
                .build();
    }

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        return OrganizationDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                .description(organization.getDescription())
                .code(organization.getCode())
                .createdDate(organization.getCreatedDate())
                .build();
    }

}
