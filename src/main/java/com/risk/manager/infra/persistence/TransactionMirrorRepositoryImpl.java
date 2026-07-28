package com.risk.manager.infra.persistence;

import com.risk.manager.domain.ports.TransactionMirrorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TransactionMirrorRepositoryImpl implements TransactionMirrorRepository {
    private SpringJpaTransactionMirrorRepository repository;

    public TransactionMirrorRepositoryImpl(SpringJpaTransactionMirrorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TransactionMirror transactionMirror) {


    }

    @Override
    public List<TransactionMirror> findBySourceUserId(UUID id) {
        return List.of();
    }

    @Override
    public List<TransactionMirror> findByDestinationUserId(UUID id) {
        return List.of();
    }

    @Override
    public List<TransactionMirror> findByIpAddress(String ipAddress) {
        return List.of();
    }

    @Override
    public List<TransactionMirror> findTop20BySenderIdOrderByCreatedAtDesc(UUID senderId, int limit) {
        return List.of();
    }
}
