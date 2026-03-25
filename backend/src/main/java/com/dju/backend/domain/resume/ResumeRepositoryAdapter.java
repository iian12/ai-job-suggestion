package com.dju.backend.domain.resume;


import com.dju.backend.domain.user.model.ids.UserId;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ResumeRepositoryAdapter implements ResumeRepository {

    private final ResumeJpaRepository resumeJpaRepository;

    public ResumeRepositoryAdapter(ResumeJpaRepository resumeJpaRepository) {
        this.resumeJpaRepository = resumeJpaRepository;
    }

    @Override
    public Optional<Resumes> findById(ResumeId id) {
        return resumeJpaRepository.findById(id.value())
                .map(ResumeMapper::toDomain);
    }

    @Override
    public List<Resumes> findByUserId(UserId userId) {
        return resumeJpaRepository.findByUserId(userId.value())
                .stream()
                .map(ResumeMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Resumes> findByUuid(String uuid) {
        return Optional.ofNullable(resumeJpaRepository.findByUuid(uuid)
                .map(ResumeMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("No Entity")));
    }

    @Override
    public Resumes save(Resumes resume) {
        ResumeEntity entity = ResumeMapper.toEntity(resume);
        ResumeEntity saved = resumeJpaRepository.save(entity);
        return ResumeMapper.toDomain(saved);
    }

    @Override
    public void deleteById(ResumeId id) {
        resumeJpaRepository.deleteById(id.value());
    }
}