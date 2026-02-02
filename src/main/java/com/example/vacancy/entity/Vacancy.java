package com.example.vacancy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameVacancy;

    private String description;

    private String company;

    private String location;

    private Integer salary;

    private String workExperience;

    private Integer weight = 0;
}
