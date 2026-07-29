package com.risk.manager.domain.ports;

import com.risk.manager.domain.RiskResult;
import com.risk.manager.domain.TransactionCompletedDTO;
import com.risk.manager.infra.api.TransactionCompletedWebDTO;

public interface AssessmentRules {
    RiskResult assess(TransactionCompletedDTO transaction);
}
