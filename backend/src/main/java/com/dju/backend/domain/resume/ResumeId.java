package com.dju.backend.domain.resume;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * @version 0.1
 * @param value
 * @author soseungyeon
 *
 * 이력서 ID 관리를 위한 값 객체입니다.
 * 데이터베이스에서 이력서 ID를 나타내는 Long 값을 래핑합니다.
 */
@Embeddable
public record ResumeId(Long value) implements Serializable {

    public static ResumeId of(Long value) {
        return new ResumeId(value);
    }
}