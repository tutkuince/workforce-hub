package com.incetutku.organizationservice.controller;

import com.incetutku.organizationservice.dto.OrganizationDto;
import com.incetutku.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto organizationDto) {
        return new ResponseEntity<>(organizationService.save(organizationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationService.getByCode(code));
    }
}
