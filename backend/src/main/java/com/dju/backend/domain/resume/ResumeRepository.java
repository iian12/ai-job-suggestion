package com.dju.backend.domain.resume;


import com.dju.backend.domain.user.model.ids.UserId;

import java.util.List;
import java.util.Optional;

public interface ResumeRepository {

    Optional<Resumes> findById(ResumeId id);

    List<Resumes> findByUserId(UserId userId);

    Optional<Resumes> findByUuid(String uuid);

    Resumes save(Resumes resume);

    void deleteById(ResumeId id);
}