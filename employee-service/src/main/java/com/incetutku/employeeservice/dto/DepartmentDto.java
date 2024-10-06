package com.incetutku.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        description = "DepartmentDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "Department Name"
    )
    private String name;
    @Schema(
            description = "Department Description"
    )
    private String description;
    @Schema(
            description = "Department Code"
    )
    private String code;

}
