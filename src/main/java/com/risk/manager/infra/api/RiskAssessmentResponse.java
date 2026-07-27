package com.risk.manager.infra.api;

import com.risk.manager.domain.AssessmentDecision;

import java.util.List;

public record RiskAssessmentResponse(int score, AssessmentDecision decision, List<String> rules) {
}
