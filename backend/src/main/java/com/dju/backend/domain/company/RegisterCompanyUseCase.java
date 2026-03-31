package com.dju.backend.domain.company;

public interface RegisterCompanyUseCase {
    // Command 바구니를 전달받아 비즈니스 로직을 수행하고, 저장이 완료된 도메인 모델을 반환.
    Companys registerCompany(RegisterCompanyCommand command);
}
