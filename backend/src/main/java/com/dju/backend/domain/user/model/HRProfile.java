package com.dju.backend.domain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HRProfile {

    @Id
    private Long id;

    private Long userId;

    private Long companyId;

    @Builder
    public HRProfile(
            Long id,
            Long userId,
            Long companyId
    ) {
        this.id = id;
        this.userId = userId;
        this.companyId = companyId;
    }
}
