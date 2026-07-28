package com.risk.manager.infra.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction_mirror", indexes = {
        @Index(name = "source_user_id_idx", columnList = "source_user_id")
})
public class TransactionMirror {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID Id;
    @Column(name = "source_user_id", nullable = false)
    private UUID sourceUserId;
    @Column(name = "destination_user_id", nullable = false)
    private UUID destinationUserId;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "ip_address", nullable = false)
    private String ipAddress;
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    public TransactionMirror(UUID id, UUID sourceUserId, UUID destinationUserId, BigDecimal amount, LocalDateTime createdAt, String ipAddress) {
        Id = id;
        this.sourceUserId = sourceUserId;
        this.destinationUserId = destinationUserId;
        this.amount = amount;
        this.createdAt = createdAt;
        this.ipAddress = ipAddress;
    }

    public TransactionMirror() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public UUID getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(UUID sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public UUID getDestinationUserId() {
        return destinationUserId;
    }

    public void setDestinationUserId(UUID destinationUserId) {
        this.destinationUserId = destinationUserId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
