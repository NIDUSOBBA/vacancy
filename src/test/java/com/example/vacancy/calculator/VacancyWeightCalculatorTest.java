package com.example.vacancy.calculator;

import com.example.vacancy.entity.Vacancy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VacancyWeightCalculatorTest {

    private final VacancyWeightCalculator calculator = new VacancyWeightCalculator();

    @Test
    @DisplayName("calculate weight for provided example vacancy")
    void shouldCalculateWeightForExampleVacancy() {
        Vacancy vacancy = Vacancy.builder()
                .nameVacancy("Java Backend Developer")
                .description("Разработка и поддержка высоконагруженных микросервисов...")
                .company("FinTech Solutions Inc.")
                .location("Москва")
                .salary(220000)
                .workExperience("От 3 лет")
                .build();

        WeightCalculationResult result =
                calculator.calculateWeight(vacancy);

        // опыт: 3 года * 10 = 30
        // name: нет в списке = 0
        // salary: 220000 / 10000 = 22
        // location: Москва = 50
        // company: нет в списке = 0
        System.out.println(result);
        assertThat(result.getTotalWeight()).isEqualTo(102);
        assertThat(result.getExperienceWeight()).isEqualTo(30);
        assertThat(result.getTitleWeight()).isEqualTo(0);
        assertThat(result.getSalaryWeight()).isEqualTo(22);
        assertThat(result.getLocationWeight()).isEqualTo(50);
        assertThat(result.getCompanyWeight()).isEqualTo(0);
    }

    @Test
    @DisplayName("calculate weight for senior manager in top city and company")
    void shouldCalculateWeightForPremiumVacancy() {
        Vacancy vacancy = Vacancy.builder()
                .nameVacancy("Senior Product Менеджер")
                .description("Управление командой разработки")
                .company("Яндекс")
                .location("Москва")
                .salary(350000)
                .workExperience("От 6 лет")
                .build();

        WeightCalculationResult result =
                calculator.calculateWeight(vacancy);

        // опыт: 6 лет * 10 = 60 (capped)
        // name: Менеджер = 1
        // salary: 350000 / 10000 = 35
        // location: Москва = 50
        // company: Яндекс = 40
        System.out.println(result);
        assertThat(result.getTotalWeight()).isEqualTo(186);
        assertThat(result.getExperienceWeight()).isEqualTo(60);
        assertThat(result.getTitleWeight()).isEqualTo(1);
        assertThat(result.getSalaryWeight()).isEqualTo(35);
        assertThat(result.getLocationWeight()).isEqualTo(50);
        assertThat(result.getCompanyWeight()).isEqualTo(40);
    }

    @Test
    @DisplayName("calculate weight for junior specialist in small city")
    void shouldCalculateWeightForEntryLevelVacancy() {
        Vacancy vacancy = Vacancy.builder()
                .nameVacancy("Младший Специалист")
                .description("Поддержка пользователей")
                .company("Local Startup LLC")
                .location("Иваново")
                .salary(65000)
                .workExperience("Не важен")
                .build();

        WeightCalculationResult result =
                calculator.calculateWeight(vacancy);

        // опыт: Не важен = 0
        // name: Специалист = 8
        // salary: 65000 / 10000 = 6
        // location: в списке нет = 5
        // company: в списке нет = 0
        assertThat(result.getTotalWeight()).isEqualTo(19);
        assertThat(result.getExperienceWeight()).isEqualTo(0);
        assertThat(result.getTitleWeight()).isEqualTo(8);
        assertThat(result.getSalaryWeight()).isEqualTo(6);
        assertThat(result.getLocationWeight()).isEqualTo(5);
        assertThat(result.getCompanyWeight()).isEqualTo(0);
    }
}



