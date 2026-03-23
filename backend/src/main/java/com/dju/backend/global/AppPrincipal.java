package com.dju.backend.global;

import com.dju.backend.domain.user.auth.AuthProvider;
import com.dju.backend.domain.user.model.enums.Role;

public interface AppPrincipal {
    Long userId();
    Role role();
    AuthProvider provider();

    default boolean isAdmin() {
        return role() == Role.ADMIN;
    }

    default boolean isLocalUser() {
        return provider() == AuthProvider.LOCAL;
    }

    default boolean isOAuthUser() {
        return provider() != AuthProvider.LOCAL;
    }
}