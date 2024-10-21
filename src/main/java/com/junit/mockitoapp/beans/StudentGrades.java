package com.junit.mockitoapp.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGrades {

    List<Double> mathGradeResults;

    public double addGrades() {
        return mathGradeResults.stream()
                .mapToDouble(Double::doubleValue).sum();
    }

}
