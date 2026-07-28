package com.risk.manager.domain;

import com.risk.manager.domain.AssessmentDecision;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    private RiskAssessment(UUID id, int score, List<String> triggeredRules, AssessmentDecision decision, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.score = score;
        this.triggeredRules = triggeredRules;
        this.decision = decision;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public static RiskAssessment create(int score, List<String> triggeredRules){
        if(score < 0){
            throw new InvalidScoreException(score);
        }
        if (triggeredRules == null){
            throw new RuntimeException();
        }
        AssessmentDecision assessmentDecision;
        if(score < 40){
            assessmentDecision = AssessmentDecision.APPROVE;
        } else if (score > 40 && score < 69) {
            assessmentDecision = AssessmentDecision.FLAGGED;
        }else {
            assessmentDecision = AssessmentDecision.REJECT;
        }

        return new RiskAssessment(
                UUID.randomUUID(),
                score,
                triggeredRules,
                assessmentDecision,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }


    }

}
