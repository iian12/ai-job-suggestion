package com.dju.backend.global;

import com.dju.backend.domain.user.auth.AuthProvider;
import com.dju.backend.domain.user.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails, AppPrincipal {

    private final Long userId;
    private final String email;
    private final String password;
    private final Role role;
    private final AuthProvider provider;

    public UserPrincipal(
            Long userId,
            String email,
            String password,
            Role role,
            AuthProvider provider
    ) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.provider = provider;
    }

    public static UserPrincipal of(
            Long userId,
            String email,
            String password,
            Role role,
            AuthProvider provider
    ) {
        return new UserPrincipal(userId, email, password, role, provider);
    }

    @Override
    public Long userId() {
        return userId;
    }

    @Override
    public Role role() {
        return role;
    }

    @Override
    public AuthProvider provider() {
        return provider;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}