package com.dju.backend.domain.recruitment;

public record RecruitmentId(Long value) {
    public static RecruitmentId of(Long value) {
        return new RecruitmentId(value);
    }
}
