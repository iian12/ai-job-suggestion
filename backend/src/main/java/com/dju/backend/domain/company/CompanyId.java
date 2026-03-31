package com.dju.backend.domain.company;

/**
 * 기업의 고유 식별자를 나타내는 Value Object
 * - record를 사용하여 값이 한 번 생성되면 변경되지 않음(불변성)을 보장함.
 * - Long 타입의 id를 래핑하여, 다른 ID(예: UserId)와 실수로 섞이는 것을 컴파일 단계에서 방지.
 */
public record CompanyId(Long value) {
}
