package com.risk.manager.infra.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskController {
    @PostMapping("/assess")
    public ResponseEntity<RiskAssessmentResponse> assessRisk(@RequestBody TransactionCompletedDTO request){

    }
}
