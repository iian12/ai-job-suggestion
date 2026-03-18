package com.dju.backend.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class AuthMethods {

    @Id
    private Long id;

    private Long userId;

    private AuthProvider provider;

    private String username;

    private String subjectId;

    private String password;

    @Builder
    public AuthMethods(
            Long id,
            Long userId,
            AuthProvider provider,
            String username,
            String subjectId,
            String password
    ) {
        this.id = id;
        this.userId = userId;
        this.provider = provider;
        this.username = username;
        this.subjectId = subjectId;
        this.password = password;
    }

    public AuthMethods of(
            Long id,
            Long userId,
            AuthProvider provider,
            String username,
            String subjectId,
            String password
    ) {
        return AuthMethods.builder()
                .id(id)
                .userId(userId)
                .provider(provider)
                .username(username)
                .subjectId(subjectId)
                .password(password)
                .build();
    }
}
