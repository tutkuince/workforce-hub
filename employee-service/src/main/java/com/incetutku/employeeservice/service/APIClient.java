package com.incetutku.employeeservice.service;

import com.incetutku.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/v1/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);
}
