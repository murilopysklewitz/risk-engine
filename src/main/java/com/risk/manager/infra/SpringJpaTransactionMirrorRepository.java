package com.risk.manager.infra;

import com.risk.manager.domain.TransactionMirror;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringJpaTransactionMirrorRepository extends JpaRepository<TransactionMirror, UUID> {
}
