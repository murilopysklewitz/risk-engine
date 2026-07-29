package com.risk.manager.infra.persistence;

import com.risk.manager.domain.RiskAssessment;
import com.risk.manager.domain.ports.RiskAssessmentRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RiskAssessmentRepositoryImpl implements RiskAssessmentRepository {
    private SpringJpaRiskAssessmentRepository repository;
    private RiskAssessmentMapper mapper;

    public RiskAssessmentRepositoryImpl(SpringJpaRiskAssessmentRepository repository, RiskAssessmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void save(RiskAssessment riskAssessment) {
        RiskAssessmentEntity entity = mapper.toEntity(riskAssessment);
        repository.save(entity);
    }

    @Override
    public void delete(UID Assessment_id) {

    }

    @Override
    public Optional<RiskAssessment> findById(UUID assessmentId) {
        return Optional.empty();
    }
}
