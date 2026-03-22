package com.dju.backend.domain.user.repository;

import com.dju.backend.domain.user.model.ids.UserId;
import com.dju.backend.domain.user.model.Users;

import java.util.Optional;

public interface UserRepository {

    Optional<Users> findById(UserId id);

    Optional<Users> findByEmail(String email);

    Optional<Users> findByPhoneNumber(String phoneNumber);

    Users save(Users user);
}
