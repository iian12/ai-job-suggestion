package com.dju.backend.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 스프링에게 이 클래스가 비즈니스 로직을 처리하는 서비스 계층임을 알려줌
@RequiredArgsConstructor // final로 선언된 필드의 생성자를 자동으로 만들어 의존성을 주입해 줌
@Transactional // DB 작업 중 에러가 발생하면, 반영된 내용을 안전하게 이전 상태로 되돌림(롤백).
public class CompanyService implements RegisterCompanyUseCase{
    // DB 저장을 위해 영속성 계층의 인터페이스(Port)를 주입받습니다.
    private final CompanyRepository companyRepository;

    @Override
    public Companys registerCompany(RegisterCompanyCommand command) {

        // [추가된 보완점] 1. 비즈니스 예외 처리 (중복 기업 검증)
        // 도메인을 생성하기 전에, 이미 등록된 이름인지 DB(포트)에 물어봄
        if (companyRepository.existsByName(command.name())) {
            // 중복이라면 우리가 만든 전용 예외를 던져 로직을 즉시 중단합니다.
            throw new CompanyAlreadyExistsException("이미 등록된 기업 이름입니다: " + command.name());
        }
        // 1. 순수 도메인 객체 생성 및 검증
        // Command에서 데이터를 꺼내 도메인의 정적 팩토리 메서드(create)로 전달.
        // 이때 이름이 비었는지, 연봉이 음수인지 등의 데이터 유효성 검증이 도메인 내부에서 자동으로 수행.
        Companys newCompany = Companys.create(
                command.name(),
                command.scale(),
                command.avgSalary(),
                command.workerCount()
        );

        // 2. 데이터베이스 저장 지시
        // 검증을 무사히 통과하여 만들어진 도메인 객체를 Repository에 넘겨 DB 저장을 지시함
        return companyRepository.save(newCompany);
    }
}
