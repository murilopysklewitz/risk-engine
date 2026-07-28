package com.risk.manager.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringJpaTransactionMirrorRepository extends JpaRepository<TransactionMirror, UUID> {
}
