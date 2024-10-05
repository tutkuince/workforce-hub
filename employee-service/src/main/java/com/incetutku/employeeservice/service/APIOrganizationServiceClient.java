package com.incetutku.employeeservice.service;

import com.incetutku.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface APIOrganizationServiceClient {

    @GetMapping("/api/v1/organizations/{code}")
    OrganizationDto getOrganizationByCode(@PathVariable String code);
}
