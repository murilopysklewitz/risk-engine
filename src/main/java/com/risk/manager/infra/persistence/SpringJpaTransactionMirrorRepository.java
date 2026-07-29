package com.risk.manager.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface SpringJpaTransactionMirrorRepository extends JpaRepository<TransactionMirrorEntity, UUID> {
    @Query("SELECT t FROM TransactionMirrorEntity t WHERE t.sourceUserId = :sourceUserId ORDER BY t.createdAt DESC")
    List<TransactionMirrorEntity> findTopXBySourceUserIdOrderByCreatedAtDesc(@Param("senderId") UUID sourceUserId, Pageable pageable);

}
