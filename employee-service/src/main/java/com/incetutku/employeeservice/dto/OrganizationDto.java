package com.incetutku.employeeservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDto {
    private Long id;
    private String name;
    private String description;
    private String code;
    private LocalDateTime createdDate;
}
