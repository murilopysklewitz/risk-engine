package com.risk.manager.domain.ports;

import com.risk.manager.infra.persistence.TransactionMirror;

import java.util.List;
import java.util.UUID;

public interface TransactionMirrorRepository {
    void save(TransactionMirror transactionMirror);
    List<TransactionMirror> findBySourceUserId(UUID id);
    List<TransactionMirror> findByDestinationUserId(UUID id);
    List<TransactionMirror> findByIpAddress(String ipAddress);

}
