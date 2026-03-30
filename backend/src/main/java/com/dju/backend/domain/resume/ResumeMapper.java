package com.dju.backend.domain.resume;

import com.dju.backend.domain.user.model.ids.UserId;

public class ResumeMapper {
    private ResumeMapper() {}

    // ✅ Entity → Domain
    public static Resumes toDomain(ResumeEntity e) {
        return Resumes.rehydrate(
                ResumeId.of(e.getId()),
                e.getName(),
                e.getOriginalFileName(),
                e.getUuid(),
                e.getFormat(),
                UserId.of(e.getUserId()),
                e.getStoredPath(),
                e.getSize(),
                e.getCreatedAt()
        );
    }

    // ✅ Domain → Entity
    public static ResumeEntity toEntity(Resumes d) {
        return ResumeEntity.of(
                d.getId().value(),
                d.getName(),
                d.getOriginalFileName(),
                d.getUuid(),
                d.getFormat(),
                d.getUserId().value(),
                d.getStoredPath(),
                d.getSize(),
                d.getCreatedAt()
        );
    }
}
