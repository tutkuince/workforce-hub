package com.incetutku.departmentservice.mapper;

import com.incetutku.departmentservice.dto.DepartmentDto;
import com.incetutku.departmentservice.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return Department.builder()
                .id(departmentDto.getId())
                .name(departmentDto.getName())
                .description(departmentDto.getDescription())
                .code(departmentDto.getCode())
                .build();
    }

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .code(department.getCode())
                .build();
    }
}
