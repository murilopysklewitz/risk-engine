package com.risk.manager.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RiskAssessment {
    private UUID id;
    private UUID transactionId;
    private int score;
    private List<String> triggeredRules;
    private AssessmentDecision decision;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
