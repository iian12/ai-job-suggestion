package com.dju.backend.domain.user.model;

import com.dju.backend.domain.user.model.enums.EducationLevel;
import com.dju.backend.domain.user.model.enums.Gender;
import com.dju.backend.domain.user.model.enums.MilitaryStatus;
import com.dju.backend.domain.user.model.ids.JobSeekerProfileId;
import com.dju.backend.domain.user.model.ids.UserId;
import lombok.Getter;

@Getter
public class JobSeekerProfiles {

    private final JobSeekerProfileId id;
    private final UserId userId;
    private Integer birthYear;
    private Integer careerYears;
    private String careerSummary;
    private String city;
    private String district;
    private Integer desiredSalary;
    private final Gender gender;
    private MilitaryStatus militaryStatus;
    private EducationLevel educationLevel;
    private String introduction;
    private boolean openToWork;

    public JobSeekerProfiles(JobSeekerProfileId id, UserId userId, Integer birthYear, Integer careerYears, String careerSummary, String city, String district, Integer desiredSalary, Gender gender, MilitaryStatus militaryStatus, EducationLevel educationLevel, String introduction, boolean openToWork) {
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

    public static JobSeekerProfiles createJobSeekerProfile(JobSeekerProfileId id, UserId userId, Integer birthYear, Integer careerYears, String careerSummary, String city, String district, Integer desiredSalary, Gender gender, MilitaryStatus militaryStatus, EducationLevel educationLevel, String introduction, boolean openToWork) {
        return new JobSeekerProfiles(id, userId, birthYear, careerYears, careerSummary, city, district, desiredSalary, gender, militaryStatus, educationLevel, introduction, openToWork);
    }

    public static JobSeekerProfiles rehydrate(
            JobSeekerProfileId id,
            UserId userId,
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
        return new JobSeekerProfiles(id, userId, birthYear, careerYears, careerSummary, city, district, desiredSalary, gender, militaryStatus, educationLevel, introduction, openToWork);
    }

    public void updateProfile(Integer birthYear, Integer careerYears, String careerSummary, String city, String district, Integer desiredSalary, MilitaryStatus militaryStatus, EducationLevel educationLevel, String introduction, boolean openToWork) {
        this.birthYear = birthYear;
        this.careerYears = careerYears;
        this.careerSummary = careerSummary;
        this.city = city;
        this.district = district;
        this.desiredSalary = desiredSalary;
        this.militaryStatus = militaryStatus;
        this.educationLevel = educationLevel;
        this.introduction = introduction;
        this.openToWork = openToWork;
    }
}
