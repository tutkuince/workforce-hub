package com.incetutku.employeeservice.service;

import com.incetutku.employeeservice.dto.APIResponseDto;
import com.incetutku.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);

    APIResponseDto getById(Long id);
}

