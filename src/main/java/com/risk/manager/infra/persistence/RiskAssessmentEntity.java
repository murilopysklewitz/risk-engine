package com.risk.manager.infra.persistence;

import com.risk.manager.domain.AssessmentDecision;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "RiskAssessment")
@Table(name = "risk_assessment", indexes = {
        @Index(name = "id_idx", columnList = "id"),
        @Index(name = "transaction_id_idx", columnList = "transaction_id"),
        @Index(name = "decision_idx", columnList = "decision"),
        @Index(name = "score_idx", columnList = "score"),
        @Index(name = "created_at_idx", columnList = "created_at")
})
public class RiskAssessmentEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "transaction_id", nullable = false)
    private UUID transactionId;
    @Column(name = "score", nullable = false)
    private int score;
    @Column(name = "triggered_rules")
    private List<String> triggeredRules;
    @Column(name = "decision")
    private AssessmentDecision decision;
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public RiskAssessmentEntity(UUID id,UUID transactionId, int score, List<String> triggeredRules, AssessmentDecision decision, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.transactionId = transactionId;
        this.score = score;
        this.triggeredRules = triggeredRules;
        this.decision = decision;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public RiskAssessmentEntity() {
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getTriggeredRules() {
        return triggeredRules;
    }

    public void setTriggeredRules(List<String> triggeredRules) {
        this.triggeredRules = triggeredRules;
    }

    public AssessmentDecision getDecision() {
        return decision;
    }

    public void setDecision(AssessmentDecision decision) {
        this.decision = decision;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
