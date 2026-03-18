package com.dju.backend.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @version 0.1
 * @author Minchan Park
 * 사용자 엔티티입니다. 사용자 ID, 이메일, 이름, 전화번호, 역할, 상태 등의 정보를 포함합니다. 데이터베이스의 users 테이블과 매핑됩니다.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @Column
    private Long id;            // PK (TSID)

    private String email;       // 사용자 이메일

    @Column
    private String name;        // 사용자 이름

    private String phoneNumber; // 사용자 전화번호

    @Enumerated(EnumType.STRING)
    private Role role;          // 사용자 역할 (type: ADMIN, JOB_SEEKER, HR)

    @Enumerated(EnumType.STRING)
    private UserStatus status;  // 사용자 상태 (type: ACTIVE, BLOCKED, DELETED)

    @Builder
    public UserEntity(
            Long id,
            String email,
            String name,
            String phoneNumber,
            Role role,
            UserStatus status
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
    }

    public static UserEntity of(
            Long id,
            String email,
            String name,
            String phoneNumber,
            Role role,
            UserStatus status
    ) {
        return UserEntity.builder()
                .id(id)
                .email(email)
                .name(name)
                .phoneNumber(phoneNumber)
                .role(role)
                .status(status)
                .build();
    }
}
