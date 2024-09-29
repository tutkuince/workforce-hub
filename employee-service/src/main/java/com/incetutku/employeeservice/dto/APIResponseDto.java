package com.incetutku.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
