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

    public static RiskAssessment create(int score, UUID transactionId, List<String> triggeredRules) {
        if (score < 0) {
            throw new InvalidScoreException(score);
        }
        AssessmentDecision assessmentDecision = null;
        if (transactionId == null) {
            throw new InvalidTransactionId();
        }
            if (triggeredRules == null) {
                throw new RuntimeException();
            }
            if (score < 40) {
                assessmentDecision = AssessmentDecision.APPROVE;
            } else if (score >= 40 && score < 69) {
                assessmentDecision = AssessmentDecision.FLAGGED;
            } else {
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
    public static RiskAssessment restore(UUID id, int score, List<String> triggeredRules, AssessmentDecision decision, LocalDateTime createdAt, LocalDateTime updatedAt){
        return new RiskAssessment(id,score,triggeredRules,decision,createdAt,updatedAt);
    }

    public UUID getId() {
        return id;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public int getScore() {
        return score;
    }

    public List<String> getTriggeredRules() {
        return triggeredRules;
    }

    public AssessmentDecision getDecision() {
        return decision;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
