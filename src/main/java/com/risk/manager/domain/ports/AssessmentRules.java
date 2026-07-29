package com.risk.manager.domain.ports;

import com.risk.manager.domain.RiskAssessment;
import com.risk.manager.domain.RiskResult;
import com.risk.manager.infra.api.TransactionCompletedDTO;

public interface AssessmentRules {
    RiskAssessment assess(TransactionCompletedDTO transaction);
}
