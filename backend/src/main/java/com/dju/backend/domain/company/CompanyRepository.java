package com.dju.backend.domain.company;
import java.util.Optional;

public interface CompanyRepository {
    Companys save(Companys companys);
    Optional<Companys> findById(CompanyId id);

    // 서비스 계층이 DB 기술을 모른 채로 중복 검사를 지시할 수 있게 메뉴판에 추가.
    boolean existsByName(String name);
}
