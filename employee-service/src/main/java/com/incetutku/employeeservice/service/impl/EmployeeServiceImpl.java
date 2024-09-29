package com.incetutku.employeeservice.service.impl;

import com.incetutku.employeeservice.dto.APIResponseDto;
import com.incetutku.employeeservice.dto.DepartmentDto;
import com.incetutku.employeeservice.dto.EmployeeDto;
import com.incetutku.employeeservice.entity.Employee;
import com.incetutku.employeeservice.mapper.EmployeeMapper;
import com.incetutku.employeeservice.repository.EmployeeRepository;
import com.incetutku.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final WebClient webClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, WebClient webClient) {
        this.employeeRepository = employeeRepository;
        this.webClient = webClient;
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
            DepartmentDto departmentDto = webClient.get()
                    .uri("http://localhost:8080/api/v1/departments/" + optionalEmployee.get().getDepartmentCode())
                    .retrieve()
                    .bodyToMono(DepartmentDto.class)
                    .block();

            EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(optionalEmployee.get());

            return APIResponseDto.builder()
                    .employeeDto(employeeDto)
                    .departmentDto(departmentDto)
                    .build();
        }

        return null;
    }
}
