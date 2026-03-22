package com.dju.backend.domain.user.model;

import com.dju.backend.domain.user.model.enums.Role;
import com.dju.backend.domain.user.model.enums.UserStatus;
import com.dju.backend.domain.user.model.ids.UserId;
import lombok.Getter;

@Getter
public class Users {

    private final UserId id;
    private String email;
    private String name;
    private String phoneNumber;
    private final Role role;
    private UserStatus userStatus;

    public Users(UserId id, String email, String name, String phoneNumber, Role role, UserStatus userStatus) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userStatus = userStatus;
    }

    //  사용자 생성
    // 검증은 항상 생성 단계에서 진행 ex) Validate(email)
    public static Users createUser(
            UserId id,
            String email,
            String name,
            String phoneNumber,
            UserStatus userStatus
    ) {
        return new Users(
                id,
                email,
                name,
                phoneNumber,
                Role.JOB_SEEKER,
                userStatus
        );
    }

    // JPA에서 로드한 값을 도메인 모델로 변경
    public static Users rehydrate(
            UserId id,
            String email,
            String name,
            String phoneNumber,
            Role role,
            UserStatus userStatus
    ) {
        return new Users(id, email, name, phoneNumber, role, userStatus);
    }

    // 이메일 변경
    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    // 이름 변경
    public void changeName(String newName) {
        this.name = newName;
    }

    // 휴대폰 번호 변경
    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // 사용자 상태 변경
    public void changeUserStatus(UserStatus newUserStatus) {
        this.userStatus = newUserStatus;
    }
}
