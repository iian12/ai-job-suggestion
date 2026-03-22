package com.dju.backend.domain.user.model.ids;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record HRProfileId(Long value) implements Serializable {
    public static HRProfileId of(Long value) {
        return new HRProfileId(value);
    }
}
