package com.dju.backend.domain.resume;

import com.dju.backend.domain.user.model.ids.UserId;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Resumes {

    private final ResumeId id;
    private String name;
    private String originalFileName;
    private final String uuid;
    private final ResumeFileFormat format;
    private final UserId userId;
    private String storedPath;
    private Long size;
    private final LocalDateTime createdAt;

    public Resumes(
            ResumeId id,
            String name,
            String originalFileName,
            String uuid,
            ResumeFileFormat format,
            UserId userId,
            String storedPath,
            Long size,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.name = name;
        this.originalFileName = originalFileName;
        this.uuid = uuid;
        this.format = format;
        this.userId = userId;
        this.storedPath = storedPath;
        this.size = size;
        this.createdAt = createdAt;
    }

    // ✅ 이력서 생성 (업로드 시)
    public static Resumes createResume(
            ResumeId id,
            String name,
            String originalFileName,
            String uuid,
            ResumeFileFormat format,
            UserId userId,
            String storedPath,
            Long size
    ) {
        return new Resumes(
                id,
                name,
                originalFileName,
                uuid, // 파일 고유 식별자
                format,
                userId,
                storedPath,
                size,
                LocalDateTime.now()
        );
    }

    // ✅ JPA → 도메인 변환
    public static Resumes rehydrate(
            ResumeId id,
            String name,
            String originalFileName,
            String uuid,
            ResumeFileFormat format,
            UserId userId,
            String storedPath,
            Long size,
            LocalDateTime createdAt
    ) {
        return new Resumes(
                id,
                name,
                originalFileName,
                uuid,
                format,
                userId,
                storedPath,
                size,
                createdAt
        );
    }

    // ✅ 이름 변경
    public void changeName(String newName) {
        this.name = newName;
    }

    // ✅ 저장 경로 변경 (파일 이동 등)
    public void changeStoredPath(String newPath) {
        this.storedPath = newPath;
    }

    // ✅ 파일 크기 변경 (재업로드 등)
    public void changeSize(Long newSize) {
        this.size = newSize;
    }
}