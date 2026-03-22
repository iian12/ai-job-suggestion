package com.dju.backend.domain.user.model.ids;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record JobSeekerProfileId(Long value) implements Serializable {
    public static JobSeekerProfileId of(Long value) {
        return new JobSeekerProfileId(value);
    }
}
