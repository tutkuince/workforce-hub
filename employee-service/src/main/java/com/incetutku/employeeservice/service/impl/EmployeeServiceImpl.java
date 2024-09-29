package com.incetutku.employeeservice.service.impl;

import com.incetutku.employeeservice.dto.APIResponseDto;
import com.incetutku.employeeservice.dto.DepartmentDto;
import com.incetutku.employeeservice.dto.EmployeeDto;
import com.incetutku.employeeservice.entity.Employee;
import com.incetutku.employeeservice.mapper.EmployeeMapper;
import com.incetutku.employeeservice.repository.EmployeeRepository;
import com.incetutku.employeeservice.service.APIClient;
import com.incetutku.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(optionalEmployee.get());

            DepartmentDto departmentDto = apiClient.getDepartmentByCode(employeeDto.getDepartmentCode());

            return APIResponseDto.builder()
                    .employeeDto(employeeDto)
                    .departmentDto(departmentDto)
                    .build();
        }

        return null;
    }
}
