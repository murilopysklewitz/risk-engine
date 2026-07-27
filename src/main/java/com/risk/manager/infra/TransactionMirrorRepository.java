package com.risk.manager.infra;

import org.springframework.stereotype.Repository;

@Repository
public class TransactionMirrorRepository {
    private SpringJpaTransactionMirrorRepository repository;

    public TransactionMirrorRepository(SpringJpaTransactionMirrorRepository repository) {
        this.repository = repository;
    }
}
