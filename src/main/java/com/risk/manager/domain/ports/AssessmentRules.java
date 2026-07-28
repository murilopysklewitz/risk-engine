package com.risk.manager.domain.ports;

import com.risk.manager.domain.RiskResult;
import com.risk.manager.infra.api.TransactionCompletedDTO;

public interface AssessmentRules {
    RiskResult assess(TransactionCompletedDTO transaction);
}
