package com.risk.manager.infra;

import com.risk.manager.domain.RiskAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringJpaRiskAssessmentRepository extends JpaRepository<RiskAssessment, UUID> {

}
