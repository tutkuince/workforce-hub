package com.incetutku.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Department Service REST APIs",
                description = "Department Service REST APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Tutku Ince",
                        email = "ti@mail.com",
                        url = "https://github.com/tutkuince"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/tutkuince"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Department-Service Doc",
                url = "https://github.com/tutkuince"
        )
)
@SpringBootApplication
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

}
