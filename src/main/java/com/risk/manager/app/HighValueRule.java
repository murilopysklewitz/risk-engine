package com.risk.manager.app;

import com.risk.manager.infra.TransactionMirrorRepository;
import org.springframework.stereotype.Component;

@Component
public class HighValueRule {
    private TransactionMirrorRepository transactionMirrorRepository;

    public HighValueRule(TransactionMirrorRepository transactionMirrorRepository) {
        this.transactionMirrorRepository = transactionMirrorRepository;
    }
}
