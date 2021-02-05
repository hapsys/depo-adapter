package com.sbrf.depo.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class MQReceiver implements Receiver<String> {

    Logger logger = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    private HTTPSender callbackSender;

    @Override
    @RabbitListener(queues = "${rabbitmq.receive.queue}")
    public Object receive(String message) {
        logger.info("Received from queue: " + message);
        this.callbackSender.send(message);
        return null;
    }
}
