package com.junit.mockitoapp.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CollegeStudent implements Student{

    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String emailAddress;

    private StudentGrades studentGrades;

    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress();
    }

    @Override
    public String getFullName() {
        return getFirstname() + " " + getLastname();
    }

    @Override
    public List<Double> getMathGrades() {
        return List.of();
    }
}
