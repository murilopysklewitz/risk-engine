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
    public void save(TransactionMirrorEntity transactionMirror) {
        repository.save(transactionMirror);

    }

    @Override
    public List<TransactionMirrorEntity> findBySourceUserId(UUID id) {
        return List.of();
    }

    @Override
    public List<TransactionMirrorEntity> findByDestinationUserId(UUID id) {
        return List.of();
    }

    @Override
    public List<TransactionMirrorEntity> findByIpAddress(String ipAddress) {
        return List.of();
    }

    @Override
    public List<TransactionMirrorEntity> findTopXBySourceUserIdOrderByCreatedAtDesc(UUID sourceUserId, int limit) {
        return List.of();
    }
}
