package com.dju.backend.domain.company;

public record  RegisterCompanyCommand (
        String name,           // 등록할 기업의 이름
        CompanyScale scale,    // 기업 규모 (Enum)
        Integer avgSalary,     // 평균 연봉
        Integer workerCount    // 임직원 수
) {
}
