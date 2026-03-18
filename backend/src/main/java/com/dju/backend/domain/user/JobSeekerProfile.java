package com.dju.backend.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobSeekerProfile {

    @Id
    private Long id;

    private Long userId;
    private int age;
    private String career;
    private String address;
    private int salary;
    private String gender;
    private boolean army;
    private String license;
    private String education;

    @Builder
    private JobSeekerProfile(
            Long id,
            Long userId,
            int age,
            String career,
            String address,
            int salary,
            String gender,
            boolean army,
            String license,
            String education
    ) {
        this.id = id;
        this.userId = userId;
        this.age = age;
        this.career = career;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
        this.army = army;
        this.license = license;
        this.education = education;
    }

    // ⭐ 반드시 클래스 안!
    public static JobSeekerProfile of(
            Long userId,
            int age,
            String career,
            String address,
            int salary,
            String gender,
            boolean army,
            String license,
            String education
    ) {
        return JobSeekerProfile.builder()
                .userId(userId)
                .age(age)
                .career(career)
                .address(address)
                .salary(salary)
                .gender(gender)
                .army(army)
                .license(license)
                .education(education)
                .build();
    }
}