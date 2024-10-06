package com.incetutku.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "EmployeeDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    @Schema(
            description = "Employee Name"
    )
    private String name;
    @Schema(
            description = "Employee Surname"
    )
    private String surname;
    @Schema(
            description = "Employee E-mail"
    )
    private String email;
    @Schema(
            description = "Employee Department Code"
    )
    private String departmentCode;
    @Schema(
            description = "Employee Organization Code"
    )
    private String organizationCode;
}
