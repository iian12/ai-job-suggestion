package com.dju.backend.domain.company;

import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    // Domain(Companys) -> Entity 변환
    public CompanyEntity toEntity(Companys domain) {
        if (domain == null) return null;

        return CompanyEntity.builder()
                .id(domain.getId() != null ? domain.getId().value() : null)
                .name(domain.getName())
                .scale(domain.getScale())
                .avgSalary(domain.getAvgSalary())
                .workerCount(domain.getWorkerCount())
                .marked(domain.getMarked())
                .build();
    }

    // Entity -> Domain(Companys) 변환
    public Companys toDomain(CompanyEntity entity) {
        if (entity == null) return null;

        return Companys.withId(
                new CompanyId(entity.getId()),
                entity.getName(),
                entity.getScale(),
                entity.getAvgSalary(),
                entity.getWorkerCount(),
                entity.getMarked()
        );
    }
}
