package com.risk.manager.infra.api;

import com.risk.manager.app.AssessTransactionUseCase;
import com.risk.manager.domain.RiskAssessment;
import com.risk.manager.domain.TransactionCompletedDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskController {
    private AssessTransactionUseCase assessTransactionUseCase;

    public RiskController(AssessTransactionUseCase assessTransactionUseCase) {
        this.assessTransactionUseCase = assessTransactionUseCase;
    }

    @PostMapping("/assess")
    public ResponseEntity<RiskAssessmentResponse> assessRisk(@RequestBody TransactionCompletedWebDTO request){
        TransactionCompletedDTO transactionCompletedDTO = new TransactionCompletedDTO(
                request.transactionId(),
                request.sourceUserId(),
                request.destinationUserId(),
                request.amount(),
                request.ipAddress()
        );
        RiskAssessment riskAssessment = assessTransactionUseCase.execute(transactionCompletedDTO);
        RiskAssessmentResponse response = new RiskAssessmentResponse(riskAssessment.getScore(), riskAssessment.getDecision(), riskAssessment.getTriggeredRules());
        return ResponseEntity.ok(response);

    }
}
