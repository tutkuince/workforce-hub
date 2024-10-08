package com.incetutku.employeeservice.service.impl;

import com.incetutku.employeeservice.dto.APIResponseDto;
import com.incetutku.employeeservice.dto.DepartmentDto;
import com.incetutku.employeeservice.dto.EmployeeDto;
import com.incetutku.employeeservice.dto.OrganizationDto;
import com.incetutku.employeeservice.entity.Employee;
import com.incetutku.employeeservice.mapper.EmployeeMapper;
import com.incetutku.employeeservice.repository.EmployeeRepository;
import com.incetutku.employeeservice.service.APIDepartmentServiceClient;
import com.incetutku.employeeservice.service.APIOrganizationServiceClient;
import com.incetutku.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final APIDepartmentServiceClient apiDepartmentServiceClient;
    private final APIOrganizationServiceClient apiOrganizationServiceClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            APIDepartmentServiceClient apiDepartmentServiceClient,
            APIOrganizationServiceClient apiOrganizationServiceClient) {
        this.employeeRepository = employeeRepository;
        this.apiDepartmentServiceClient = apiDepartmentServiceClient;
        this.apiOrganizationServiceClient = apiOrganizationServiceClient;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    // @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getById(Long id) {
        LOGGER.info("inside getById() method");
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(optionalEmployee.get());

            DepartmentDto departmentDto = apiDepartmentServiceClient.getDepartmentByCode(employeeDto.getDepartmentCode());
            OrganizationDto organizationDto = apiOrganizationServiceClient.getOrganizationByCode(employeeDto.getOrganizationCode());

            return APIResponseDto.builder()
                    .employeeDto(employeeDto)
                    .departmentDto(departmentDto)
                    .organizationDto(organizationDto)
                    .build();
        }
        return null;
    }

    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {
        LOGGER.info("inside getDefaultDepartment() method");
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(optionalEmployee.get());

            DepartmentDto departmentDto = DepartmentDto.builder()
                    .name("R&D Department")
                    .code("RD001")
                    .description("Research and Development Department")
                    .build();

            return APIResponseDto.builder()
                    .employeeDto(employeeDto)
                    .departmentDto(departmentDto)
                    .build();
        }
        return null;
    }
}
