package com.dju.backend.domain.user.model.ids;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * @version 0.1
 * @param value
 * @author Minchan Park
 *
 * 사용자 ID 관리를 위한 값 객체입니다. 데이터베이스에서 사용자 ID를 나타내는 Long 값을 래핑합니다.
 */
@Embeddable
public record UserId(Long value) implements Serializable {
    public static UserId of(Long value) {
        return new UserId(value);
    }
}
