package com.dju.backend.global;

import com.dju.backend.domain.user.model.ids.UserId;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserIdArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUserId.class)
                && UserId.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public @Nullable Object resolveArgument(MethodParameter parameter,
                                            @Nullable ModelAndViewContainer mavContainer,
                                            NativeWebRequest webRequest,
                                            @Nullable WebDataBinderFactory binderFactory) throws Exception {
        CurrentUserId ann = parameter.getParameterAnnotation(CurrentUserId.class);
        boolean required = ann == null || ann.required();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal() == null) {
            if (!required) return null;
            throw new AuthenticationCredentialsNotFoundException("Authentication required");
        }

        Object principal = auth.getPrincipal();
        if (principal instanceof AppPrincipal ap) {
            return UserId.of(ap.userId());
        }

        throw new AuthenticationCredentialsNotFoundException("Unsupported principal");
    }
}
