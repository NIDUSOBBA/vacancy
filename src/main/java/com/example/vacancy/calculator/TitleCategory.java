package com.example.vacancy.calculator;

import lombok.Getter;

@Getter
public enum TitleCategory {
    MANAGER("Менеджер", 1),
    DOCTOR("Доктор", 2),
    TEACHER("Учитель", 3),
    ENGINEER("Инженер", 4),
    ANALYST("Аналитик", 5),
    COOK("Повар", 6),
    DESIGNER("Дизайнер", 7),
    SPECIALIST("Специалист", 8);

    private final String keyword;
    private final int weight;

    TitleCategory(String keyword, int weight) {
        this.keyword = keyword;
        this.weight = weight;
    }

}
