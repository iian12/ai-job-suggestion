package com.dju.backend.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryAdapter implements CompanyRepository{
    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Companys save(Companys companys) {
        // 1. 도메인(Companys)을 엔티티로 변환
        CompanyEntity entity = companyMapper.toEntity(companys);

        // 2. JPA로 DB에 저장
        CompanyEntity savedEntity = companyJpaRepository.save(entity);

        // 3. 저장된 엔티티를 다시 도메인(Companys)으로 변환하여 반환
        return companyMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Companys> findById(CompanyId id) {
        // JPA로 조회 후, 결과가 있으면 Mapper를 통해 도메인(Companys) 객체로 변환
        return companyJpaRepository.findById(id.value())
                .map(companyMapper::toDomain);
    }
    @Override
    public boolean existsByName(String name) {
        return companyJpaRepository.existsByName(name);
    }
}
