package com.risk.manager.infra.persistence;

import com.risk.manager.domain.ports.RiskAssessmentRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RiskAssessmentRepositoryImpl implements RiskAssessmentRepository {
    private SpringJpaRiskAssessmentRepository repository;

    public RiskAssessmentRepositoryImpl(SpringJpaRiskAssessmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public void save(RiskAssessmentEntity riskAssessment) {

    }

    @Override
    public void delete(UID Assessment_id) {

    }

    @Override
    public Optional<RiskAssessmentEntity> findById(UUID assessmentId) {
        return Optional.empty();
    }
}
