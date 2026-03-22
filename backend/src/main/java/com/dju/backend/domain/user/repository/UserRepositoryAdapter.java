package com.dju.backend.domain.user.repository;

import com.dju.backend.domain.user.model.ids.UserId;
import com.dju.backend.domain.user.model.Users;
import com.dju.backend.domain.user.mapper.UserMapper;
import com.dju.backend.domain.user.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<Users> findById(UserId id) {
        return userJpaRepository.findById(id.value()).map(UserMapper::toDomain);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public Optional<Users> findByPhoneNumber(String phoneNumber) {
        return userJpaRepository.findByPhoneNumber(phoneNumber).map(UserMapper::toDomain);
    }

    @Override
    public Users save(Users user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        UserEntity saved = userJpaRepository.save(userEntity);
        return UserMapper.toDomain(saved);
    }
}
