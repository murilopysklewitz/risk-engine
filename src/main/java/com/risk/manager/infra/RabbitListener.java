package com.risk.manager.infra;

import com.risk.manager.domain.TransactionCompletedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

@org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "${transaction_exchange}")
public class RabbitListener {
    @RabbitHandler
    public void receiveMessage(TransactionCompletedEvent event) {

    }
}
