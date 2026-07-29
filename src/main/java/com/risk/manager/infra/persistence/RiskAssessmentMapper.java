package com.risk.manager.infra.persistence;

import com.risk.manager.domain.RiskAssessment;
import org.springframework.stereotype.Component;

@Component
public class RiskAssessmentMapper {

    public RiskAssessment toDomain(RiskAssessmentEntity entity){
        RiskAssessment domain = RiskAssessment.restore(
                entity.getId(),
                entity.getScore(),
                entity.getTriggeredRules(),
                entity.getDecision(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        return domain;
    }
    public RiskAssessmentEntity toEntity(RiskAssessment domain){
        return new RiskAssessmentEntity(
                domain.getId(),
                domain.getScore(),
                domain.getTriggeredRules(),
                domain.getDecision(),
                domain.getCreatedAt(),
                domain.getUpdatedAt()
        );
    }
}
