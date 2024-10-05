package com.incetutku.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String departmentCode;
    private String organizationCode;
}
