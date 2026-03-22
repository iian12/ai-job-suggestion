package com.dju.backend.domain.user.mapper;

import com.dju.backend.domain.user.model.ids.UserId;
import com.dju.backend.domain.user.model.Users;
import com.dju.backend.domain.user.model.UserEntity;

public class UserMapper {
    private UserMapper() {}

    public static Users toDomain(UserEntity e) {
        return Users.rehydrate(
                UserId.of(e.getId()),
                e.getEmail(),
                e.getName(),
                e.getPhoneNumber(),
                e.getRole(),
                e.getStatus()
        );
    }

    public static UserEntity toEntity(Users d) {
        return UserEntity.of(
                d.getId().value(),
                d.getEmail(),
                d.getName(),
                d.getPhoneNumber(),
                d.getRole(),
                d.getUserStatus()
        );
    }
}
