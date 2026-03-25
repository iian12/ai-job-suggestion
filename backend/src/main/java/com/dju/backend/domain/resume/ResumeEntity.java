package com.dju.backend.domain.resume;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @version 0.1
 * 이력서 파일 엔티티입니다.
 * 파일 정보 및 메타데이터를 관리합니다.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResumeEntity {

    @Id
    @Column(name = "resume_id", nullable = false, updatable = false)
    private Long id; // PK (TSID)

    @Column(nullable = false)
    private String name; // 이력서 이름

    @Column(name = "original_file_name", nullable = false)
    private String originalFileName; // 원본 파일명

    @Column(nullable = false, unique = true)
    private String uuid; // 파일 식별용 UUID

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private com.dju.backend.domain.resume.ResumeFileFormat format; // 파일 형식

    @Column(name = "user_id", nullable = false)
    private Long userId; // 작성자 ID

    @Column(name = "stored_path", nullable = false)
    private String storedPath; // 저장 경로

    @Column(nullable = false)
    private Long size; // 파일 크기

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // 생성 시간

    @Builder
    public ResumeEntity(
            Long id,
            String name,
            String originalFileName,
            String uuid,
            ResumeFileFormat format,
            Long userId,
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

    public static ResumeEntity of(
            Long id,
            String name,
            String originalFileName,
            String uuid,
            ResumeFileFormat format,
            Long userId,
            String storedPath,
            Long size,
            LocalDateTime createdAt
    ) {
        return ResumeEntity.builder()
                .id(id)
                .name(name)
                .originalFileName(originalFileName)
                .uuid(uuid)
                .format(format)
                .userId(userId)
                .storedPath(storedPath)
                .size(size)
                .createdAt(createdAt)
                .build();
    }
}