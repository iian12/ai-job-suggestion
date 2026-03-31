package com.dju.backend.domain.company;

import lombok.Getter;

@Getter
public class Companys {
    private CompanyId id;
    private String name;
    private CompanyScale scale;
    private Integer avgSalary;
    private Integer workerCount;
    private Integer marked;

    // 무분별한 객체 생성을 막기 위해 생성자를 private으로 닫아둡니다.
    private Companys(CompanyId id, String name, CompanyScale scale, Integer avgSalary, Integer workerCount, Integer marked) {
        validateName(name);
        validateScale(scale);
        validatePositiveNumber(avgSalary, "평균 연봉");
        validatePositiveNumber(workerCount, "임직원 수");
        validatePositiveNumber(marked, "관심기업 개수");

        this.id = id;
        this.name = name;
        this.scale = scale;
        this.avgSalary = avgSalary;
        this.workerCount = workerCount;
        this.marked = marked;
    }

    // ==========================================
    // 정적 팩토리 메서드
    // ==========================================

    // [정적 팩토리 메서드 1] 신규 회사 등록 시 사용 (아직 DB에 저장되지 않아 ID가 없음)
    public static Companys create(String name, CompanyScale scale, Integer avgSalary, Integer workerCount) {
        return new Companys(null, name, scale, avgSalary, workerCount, 0);
    }

    // [정적 팩토리 메서드 2] DB에서 조회한 데이터를 도메인으로 복원할 때 사용 (ID 포함)
    public static Companys withId(CompanyId id, String name, CompanyScale scale, Integer avgSalary, Integer workerCount, Integer marked) {
        return new Companys(id, name, scale, avgSalary, workerCount, marked);
    }

    // ==========================================
    // 비즈니스 로직 메서드
    // ==========================================

    // 관심기업 등록 (1 증가)
    public void increaseMarked() {
        this.marked++;
    }

    // 관심기업 취소 (1 감소, 단 0보다 작아질 수 없음)
    public void decreaseMarked() {
        if (this.marked > 0) {
            this.marked--;
        }
    }

    public void updateInfo(String newName, CompanyScale newScale, Integer newAvgSalary, Integer newWorkerCount) {
        validateName(newName);
        validateScale(newScale);
        validatePositiveNumber(newAvgSalary, "평균 연봉");
        validatePositiveNumber(newWorkerCount, "임직원 수");

        this.name = newName;
        this.scale = newScale;
        this.avgSalary = newAvgSalary;
        this.workerCount = newWorkerCount;
    }

    // ==========================================
    // 내부 검증 로직 (Validation)
    // ==========================================

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("회사 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateScale(CompanyScale scale) {
        if (scale == null) {
            throw new IllegalArgumentException("회사 규모(Scale) 정보는 필수입니다.");
        }
    }

    private void validatePositiveNumber(Integer number, String fieldName) {
        if (number != null && number < 0) {
            throw new IllegalArgumentException(fieldName + "은(는) 음수가 될 수 없습니다.");
        }
    }
}
