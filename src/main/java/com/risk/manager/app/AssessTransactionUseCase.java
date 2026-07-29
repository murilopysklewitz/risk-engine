package com.risk.manager.app;

import com.risk.manager.domain.RiskAssessment;
import com.risk.manager.domain.RiskResult;
import com.risk.manager.domain.TransactionCompletedDTO;
import com.risk.manager.domain.ports.AssessmentRules;
import com.risk.manager.domain.ports.RiskAssessmentRepository;
import com.risk.manager.domain.ports.TransactionMirrorRepository;
import com.risk.manager.infra.persistence.TransactionMirrorEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssessTransactionUseCase {
    private List<AssessmentRules> rules;
    private RiskAssessmentRepository riskAssessmentRepository;
    private TransactionMirrorRepository transactionMirrorRepository;

    public AssessTransactionUseCase(List<AssessmentRules> rules, RiskAssessmentRepository riskAssessmentRepository, TransactionMirrorRepository transactionMirrorRepository) {
        this.rules = rules;
        this.riskAssessmentRepository = riskAssessmentRepository;
        this.transactionMirrorRepository = transactionMirrorRepository;
    }

    public RiskAssessment execute(TransactionCompletedDTO transactionCompletedDTO){
        TransactionMirrorEntity transactionMirrorEntity = new TransactionMirrorEntity(transactionCompletedDTO.transactionId(),
                transactionCompletedDTO.sourceUserId(),
                transactionCompletedDTO.destinationUserId(),
                transactionCompletedDTO.amount(),
                LocalDateTime.now(),
                transactionCompletedDTO.ipAddress());
        transactionMirrorRepository.save(transactionMirrorEntity);
        int score = 0;
        List<String> triggeredRules = new ArrayList<>();

        for (AssessmentRules rule : rules){
            RiskResult result = rule.assess(transactionCompletedDTO);
            score += result.score();
            triggeredRules.add(result.rule());
        }

        RiskAssessment riskAssessment = RiskAssessment.create(score, transactionCompletedDTO.transactionId(), triggeredRules);
        riskAssessmentRepository.save(riskAssessment);
        return riskAssessment;
    }
}
