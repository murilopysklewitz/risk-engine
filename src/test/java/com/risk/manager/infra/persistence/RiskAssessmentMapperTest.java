package com.risk.manager.infra.persistence;


import com.risk.manager.domain.AssessmentDecision;
import com.risk.manager.domain.RiskAssessment;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RiskAssessmentMapperTest {
    private RiskAssessmentEntity entity;
    private RiskAssessment domain;

    @BeforeEach
    void setUp() {
        entity = new RiskAssessmentEntity(
                UUID.randomUUID(),
                10,
                List.of("test1", "test2"),
                AssessmentDecision.APPROVE,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        domain = RiskAssessment.create(10,
                )
    }
}
