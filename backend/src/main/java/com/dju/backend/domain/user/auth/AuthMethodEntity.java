package com.dju.backend.domain.user.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class AuthMethodEntity {

    @Id
    private Long id;

    private Long userId;

    private AuthProvider provider;

    private String username;

    private String subjectId;

    private String email;

    private String password;

    @Builder
    public AuthMethodEntity(
            Long id,
            Long userId,
            AuthProvider provider,
            String username,
            String subjectId,
            String email,
            String password
    ) {
        this.id = id;
        this.userId = userId;
        this.provider = provider;
        this.username = username;
        this.subjectId = subjectId;
        this.email = email;
        this.password = password;
    }

    public AuthMethodEntity of(
            Long id,
            Long userId,
            AuthProvider provider,
            String username,
            String subjectId,
            String email,
            String password
    ) {
        return AuthMethodEntity.builder()
                .id(id)
                .userId(userId)
                .provider(provider)
                .username(username)
                .subjectId(subjectId)
                .email(email)
                .password(password)
                .build();
    }
}
