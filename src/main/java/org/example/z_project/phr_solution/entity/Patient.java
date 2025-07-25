package org.example.z_project.phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
    private Long id;
    private String name;
    private int age;
    private String gender;
}
