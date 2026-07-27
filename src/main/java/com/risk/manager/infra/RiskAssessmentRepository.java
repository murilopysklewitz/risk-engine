package com.risk.manager.infra;

import org.springframework.stereotype.Repository;

@Repository
public class RiskAssessmentRepository {
    private SpringJpaRiskAssessmentRepository repository;

    public RiskAssessmentRepository(SpringJpaRiskAssessmentRepository repository) {
        this.repository = repository;
    }


}
