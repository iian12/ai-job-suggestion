package com.dju.backend.domain.recruitment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    private Long salary;                        //연봉

    private String address;                     //주소

    private String job;                         //직무

    private String qualificationRequirements;   //자격 요건

    private String mainTasks;                   //주요 업무

    private String preferentialTreatment;       //우대 사항

    private String benefits;                    //혜택

    private String welfare;                     //복지

    private String recruitmentProcess;          //채용 전형

    private String tag;                         //태그

    private String keywords;                    //키워드

    private LocalDateTime dueDate;              //마감일

    @Builder
    public RecruitmentEntity(
            Long id,
            String name,
            Long salary,
            String address,
            String job,
            String qualificationRequirements,
            String mainTasks,
            String preferentialTreatment,
            String benefits,
            String welfare,
            String recruitmentProcess,
            String tag,
            String keywords,
            LocalDateTime dueDate){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.job = job;
        this.qualificationRequirements = qualificationRequirements;
        this.mainTasks = mainTasks;
        this.preferentialTreatment = preferentialTreatment;
        this.benefits = benefits;
        this.welfare = welfare;
        this.recruitmentProcess = recruitmentProcess;
        this.tag = tag;
        this.keywords = keywords;
        this.dueDate = dueDate;
    }

    public RecruitmentEntity of(
            Long id,
            String name,
            Long salary,
            String address,
            String job,
            String qualificationRequirements,
            String mainTasks,
            String preferentialTreatment,
            String benefits,
            String welfare,
            String recruitmentProcess,
            String tag,
            String keywords,
            LocalDateTime dueDate) {
        return RecruitmentEntity.builder()
                .id(id)
                .name(name)
                .salary(salary)
                .address(address)
                .job(job)
                .qualificationRequirements(qualificationRequirements)
                .mainTasks(mainTasks)
                .preferentialTreatment(preferentialTreatment)
                .benefits(benefits)
                .welfare(welfare)
                .recruitmentProcess(recruitmentProcess)
                .tag(tag)
                .keywords(keywords)
                .dueDate(dueDate)
                .build();
    }
}
