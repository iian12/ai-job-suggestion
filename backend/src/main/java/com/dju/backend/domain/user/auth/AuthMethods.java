package com.dju.backend.domain.user.auth;

import com.dju.backend.domain.user.model.ids.UserId;
import lombok.Getter;


// 이메일, 비밀번호 변경 시 기존 테이블 업데이트
@Getter
public class AuthMethods {

    private final AuthMethodId id;
    private final UserId userId;
    private final AuthProvider provider;
    private final String username;
    private final String subjectId;
    private String email;
    private String password;

    public AuthMethods(
            AuthMethodId id,
            UserId userId,
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

    public static AuthMethods createAuthMethods(
            AuthMethodId id,
            UserId userId,
            AuthProvider provider,
            String username,
            String subjectId,
            String email,
            String password
    ) {
        return new AuthMethods(id, userId, provider, username, subjectId, email, password);
    }

    public static AuthMethods rehydrate(
            AuthMethodId id,
            UserId userId,
            AuthProvider provider,
            String username,
            String subjectId,
            String email,
            String password
    ) {
        return new AuthMethods(id, userId, provider, username, subjectId, email, password);
    }

    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
