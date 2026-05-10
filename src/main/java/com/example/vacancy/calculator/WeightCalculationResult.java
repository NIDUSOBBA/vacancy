package com.example.vacancy.calculator;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class WeightCalculationResult {
    int totalWeight;
    int experienceWeight;
    int titleWeight;
    int salaryWeight;
    int locationWeight;
    int companyWeight;

    @Override
    public String toString() {
        return String.format(
                "WeightCalculationResult{total=%d, factors={exp=%d, title=%d, salary=%d, location=%d, company=%d}}",
                totalWeight, experienceWeight, titleWeight, salaryWeight, locationWeight, companyWeight
        );
    }
}
