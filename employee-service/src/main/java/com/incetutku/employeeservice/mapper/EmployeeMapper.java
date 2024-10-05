package com.incetutku.employeeservice.mapper;

import com.incetutku.employeeservice.dto.EmployeeDto;
import com.incetutku.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .surname(employeeDto.getSurname())
                .email(employeeDto.getEmail())
                .departmentCode(employeeDto.getDepartmentCode())
                .organizationCode(employeeDto.getOrganizationCode())
                .build();
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .email(employee.getEmail())
                .departmentCode(employee.getDepartmentCode())
                .organizationCode(employee.getOrganizationCode())
                .build();
    }
}
