package com.risk.manager.domain;

import com.risk.manager.domain.ports.AssessmentRules;
import com.risk.manager.domain.ports.TransactionMirrorRepository;
import com.risk.manager.infra.api.TransactionCompletedDTO;
import com.risk.manager.infra.persistence.TransactionMirror;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HighValueRule implements AssessmentRules {
    private TransactionMirrorRepository transactionMirrorRepository;

    public HighValueRule(TransactionMirrorRepository transactionMirrorRepository) {
        this.transactionMirrorRepository = transactionMirrorRepository;
    }

    @Override
    public RiskResult assess(TransactionCompletedDTO transaction) {
        List<TransactionMirror> transactions = transactionMirrorRepository.findTopXBySourceUserIdOrderByCreatedAtDesc(transaction.sourceUserId(),20);
    }
}
