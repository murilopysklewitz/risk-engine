package com.risk.manager.infra.persistence;

import com.risk.manager.domain.ports.TransactionMirrorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionMirrorRepositoryImpl implements TransactionMirrorRepository {
    private SpringJpaTransactionMirrorRepository repository;

    public TransactionMirrorRepositoryImpl(SpringJpaTransactionMirrorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TransactionMirror transactionMirror) {


    }
}
