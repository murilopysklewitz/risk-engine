package com.risk.manager.infra.api;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionCompletedWebDTO(@NotNull UUID transactionId,
                                         @NotNull UUID sourceUserId,
                                         @NotNull UUID destinationUserId,
                                         @NotNull BigDecimal amount,
                                         @NotNull String ipAddress) { }
