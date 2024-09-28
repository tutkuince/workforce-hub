package com.incetutku.departmentservice.service.impl;

import com.incetutku.departmentservice.dto.DepartmentDto;
import com.incetutku.departmentservice.entity.Department;
import com.incetutku.departmentservice.mapper.DepartmentMapper;
import com.incetutku.departmentservice.repository.DepartmentRepository;
import com.incetutku.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
