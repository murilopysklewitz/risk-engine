package com.risk.manager.infra;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

@org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "${transaction_exchange}")
public class RabbitListener {
}
