package com.incetutku.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(
        description = "OrganizationDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDto {
    private Long id;
    @Schema(
            description = "Organization Name"
    )
    private String name;
    @Schema(
            description = "Organization Description"
    )
    private String description;
    @Schema(
            description = "Organization Code"
    )
    private String code;
    @Schema(
            description = "Organization Created Date"
    )
    private LocalDateTime createdDate;
}
