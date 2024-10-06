package com.incetutku.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "APIResponseDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponseDto {
    @Schema(
            description = "APIResponseDto - EmployeeDto"
    )
    private EmployeeDto employeeDto;
    @Schema(
            description = "APIResponseDto - DepartmentDto"
    )
    private DepartmentDto departmentDto;
    @Schema(
            description = "APIResponseDto - OrganizationDto"
    )
    private OrganizationDto organizationDto;
}
