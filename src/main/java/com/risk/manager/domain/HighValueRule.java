package com.risk.manager.domain;

import com.risk.manager.domain.ports.AssessmentRules;
import com.risk.manager.domain.ports.TransactionMirrorRepository;
import com.risk.manager.infra.api.TransactionCompletedDTO;
import com.risk.manager.infra.persistence.TransactionMirror;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class HighValueRule implements AssessmentRules {
    private TransactionMirrorRepository transactionMirrorRepository;

    public HighValueRule(TransactionMirrorRepository transactionMirrorRepository) {
        this.transactionMirrorRepository = transactionMirrorRepository;
    }

    @Override
    public RiskAssessment assess(TransactionCompletedDTO transaction) {
        List<TransactionMirror> transactions = transactionMirrorRepository.findTopXBySourceUserIdOrderByCreatedAtDesc(transaction.sourceUserId(),20);
        BigDecimal sum = BigDecimal.ZERO;
        for(TransactionMirror t : transactions){
            sum = sum.add(t.getAmount());
        }
        BigDecimal average = sum.divide(transaction.amount(), RoundingMode.HALF_DOWN);

        int scoreCalculator =transaction.amount().divide(average, RoundingMode.HALF_DOWN).intValue();
        int score = 0;
        if ( scoreCalculator >= 2 && scoreCalculator < 2.99){
            score = 15;
        }else if( scoreCalculator >= 3 && scoreCalculator < 4){
            score = 35;
        }

        return RiskAssessment.create(score, List.of("HIGH_VALUE_RULE"));
    }
}
