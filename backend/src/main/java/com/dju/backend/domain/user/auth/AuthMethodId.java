package com.dju.backend.domain.user.auth;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record AuthMethodId(Long value) implements Serializable {
        public static AuthMethodId of(Long value) {
            return new AuthMethodId(value);
        }
}
