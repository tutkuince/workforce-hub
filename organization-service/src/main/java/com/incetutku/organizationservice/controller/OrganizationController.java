package com.incetutku.organizationservice.controller;

import com.incetutku.organizationservice.dto.OrganizationDto;
import com.incetutku.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - Organization Controller",
        description = "Organization Controller Exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save organization object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto organizationDto) {
        return new ResponseEntity<>(organizationService.save(organizationDto), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Organization By Code REST API",
            description = "Get Organization By Code REST API is used to get a organization object in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationService.getByCode(code));
    }
}
