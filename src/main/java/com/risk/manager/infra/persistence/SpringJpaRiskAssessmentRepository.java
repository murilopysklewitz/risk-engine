package com.risk.manager.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringJpaRiskAssessmentRepository extends JpaRepository<RiskAssessmentEntity, UUID> {

}
