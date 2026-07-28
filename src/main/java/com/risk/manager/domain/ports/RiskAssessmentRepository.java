package com.risk.manager.domain.ports;

import com.risk.manager.infra.persistence.RiskAssessmentEntity;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

public interface RiskAssessmentRepository {
    void save(RiskAssessmentEntity riskAssessment);
    void delete(UID Assessment_id);
    Optional<RiskAssessmentEntity> findById(UUID assessmentId);
}
