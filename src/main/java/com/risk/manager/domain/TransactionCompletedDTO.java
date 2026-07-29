package com.risk.manager.domain;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionCompletedDTO(UUID transactionId,
                                      UUID sourceUserId,
                                      UUID destinationUserId,
                                      BigDecimal amount,
                                      String ipAddress) {
}
