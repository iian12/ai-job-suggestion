package com.dju.backend.domain.resume;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ResumeJpaRepository extends JpaRepository<ResumeEntity, Long> {

    List<ResumeEntity> findByUserId(Long userId);

    Optional<ResumeEntity> findByUuid(String uuid);
}