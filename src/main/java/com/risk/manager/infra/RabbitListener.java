package com.risk.manager.infra;

import com.risk.manager.app.AssessTransactionUseCase;
import com.risk.manager.domain.TransactionCompletedDTO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

@Component
public class RabbitListener {
    private final AssessTransactionUseCase assessTransactionUseCase;

    public RabbitListener(AssessTransactionUseCase assessTransactionUseCase) {
        this.assessTransactionUseCase = assessTransactionUseCase;
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitMQConfig.RISK_ENGINE_QUEUE)
    void rabbitListener(TransactionCompletedDTO transactionCompletedDTO){
        assessTransactionUseCase.execute(transactionCompletedDTO);

    }
}
