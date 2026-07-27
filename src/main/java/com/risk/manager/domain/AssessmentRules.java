package com.risk.manager.domain;

import com.risk.manager.infra.api.TransactionCompletedDTO;

public interface AssessmentRules {
    RiskResult assess(TransactionCompletedDTO transaction);
}
