package com.risk.manager.domain.ports;


import com.risk.manager.infra.persistence.TransactionMirrorEntity;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface TransactionMirrorRepository {
    void save(TransactionMirrorEntity transactionMirror);
    List<TransactionMirrorEntity> findBySourceUserId(UUID id);
    List<TransactionMirrorEntity> findByDestinationUserId(UUID id);
    List<TransactionMirrorEntity> findByIpAddress(String ipAddress);
    List<TransactionMirrorEntity> findTopXBySourceUserIdOrderByCreatedAtDesc(UUID sourceUserId,  int limit);

}
