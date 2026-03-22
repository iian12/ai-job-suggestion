package com.dju.backend.domain.user.model;

import com.dju.backend.domain.user.model.enums.EducationLevel;
import com.dju.backend.domain.user.model.enums.Gender;
import com.dju.backend.domain.user.model.enums.MilitaryStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobSeekerProfileEntity {

    @Id
    private Long id;
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;
    @Column
    private Integer birthYear;                  // 생년 연도
    @Column
    private Integer careerYears;                // 전체 경력 연수
    @Column
    private String careerSummary;               // 경력 요약
    @Column
    private String city;                        // 지역
    @Column
    private String district;                    // 구/군
    @Column
    private Integer desiredSalary;              // 희망 연봉
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;                      // 성별
    @Column
    @Enumerated(EnumType.STRING)
    private MilitaryStatus militaryStatus;      // 병역 사항(예시: NOT_APPLICABLE, EXEMPTED, COMPLETED, PENDING)
    @Column
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;  // 학력 수준(예시: HIGH_SCHOOL, Associate, BACHELORS, MASTERS, DOCTORATE)
    @Column
    private String introduction;        // 한 줄 소개
    @Column
    private boolean openToWork;         // 구직 중 여부

    @Builder
    public JobSeekerProfileEntity(
            Long id,
            Long userId,
            Integer birthYear,
            Integer careerYears,
            String careerSummary,
            String city,
            String district,
            Integer desiredSalary,
            Gender gender,
            MilitaryStatus militaryStatus,
            EducationLevel educationLevel,
            String introduction,
            boolean openToWork
    ) {
        this.id = id;
        this.userId = userId;
        this.birthYear = birthYear;
        this.careerYears = careerYears;
        this.careerSummary = careerSummary;
        this.city = city;
        this.district = district;
        this.desiredSalary = desiredSalary;
        this.gender = gender;
        this.militaryStatus = militaryStatus;
        this.educationLevel = educationLevel;
        this.introduction = introduction;
        this.openToWork = openToWork;
    }

    public JobSeekerProfileEntity of(
            Long id,
            Long userId,
            Integer birthYear,
            Integer careerYears,
            String careerSummary,
            String city,
            String district,
            Integer desiredSalary,
            Gender gender,
            MilitaryStatus militaryStatus,
            EducationLevel educationLevel,
            String introduction,
            boolean openToWork
    ) {
        return JobSeekerProfileEntity.builder()
                .id(id)
                .userId(userId)
                .birthYear(birthYear)
                .careerYears(careerYears)
                .careerSummary(careerSummary)
                .city(city)
                .district(district)
                .desiredSalary(desiredSalary)
                .gender(gender)
                .militaryStatus(militaryStatus)
                .educationLevel(educationLevel)
                .introduction(introduction)
                .openToWork(openToWork)
                .build();
    }
}