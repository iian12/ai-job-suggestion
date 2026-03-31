package com.dju.backend.domain.company;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 기업 정보 데이터를 담는 엔티티 클래스
 * 데이터베이스의 '기업 정보' 테이블과 직접 매핑
 */
@Entity // 이 클래스가 JPA 엔티티임을 명시 (DB 테이블과 매핑)
@Getter // 모든 필드의 Getter 메서드 자동 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 protected로 설정하여 무분별한 객체 생성을 막고 JPA 스펙을 만족시킴
public class CompanyEntity {

    @Id // 테이블의 기본키(PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 생성 전략 (DB에 따라 AUTO, SEQUENCE 등으로 변경 가능)
    @Column // 필드를 테이블의 컬럼과 매핑
    private Long id;              // 기업 고유 ID (식별자)

    // [보완] 이름은 절대 비어있을 수 없고(nullable = false), 중복될 수 없음(unique = true)
    @Column(nullable = false, unique = true)
    private String name;          // 기업명

    // [보완] 기업 규모 역시 필수값이므로 nullable = false 추가
    @Enumerated(EnumType.STRING) // Enum 값을 DB에 저장할 때 숫자가 아닌 문자열(이름 그대로)로 저장
    @Column(nullable = false)
    private CompanyScale scale;   // 기업 규모 (STARTUP, SMALL, MIDDLE, BIG)

    @Column
    private Integer avgSalary;    // 평균 연봉

    @Column
    private Integer workerCount;  // 임직원 수

    // [보완] 마크 횟수도 기본적으로 0부터 시작하는 필수값이므로 nullable = false 추가
    @Column(nullable = false)
    private Integer marked;       // 관심기업 등록 횟수

    /**
     * CompanyEntity 객체 생성을 위한 빌더
     * 가독성 좋고 안전한 객체 생성 지원
     */
    @Builder
    public CompanyEntity(
            Long id,
            String name,
            CompanyScale scale,
            Integer avgSalary,
            Integer workerCount,
            Integer marked
    ) {
        this.id = id;
        this.name = name;
        this.scale = scale;
        this.avgSalary = avgSalary;
        this.workerCount = workerCount;
        this.marked = marked;
    }

    /**
     * 정적 팩토리 메서드
     * 외부에서 CompanyEntity.of(...) 형태로 간편하게 객체를 생성할 수 있도록 지원
     */
    public static CompanyEntity of(
            Long id,
            String name,
            CompanyScale scale,
            Integer avgSalary,
            Integer workerCount,
            Integer marked
    ) {
        return CompanyEntity.builder()
                .id(id)
                .name(name)
                .scale(scale)
                .avgSalary(avgSalary)
                .workerCount(workerCount)
                .marked(marked)
                .build();
    }
}