package com.sbrf.depo.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MQSender implements Sender<String> {

    Logger logger = LoggerFactory.getLogger(MQSender.class);

    @Value("${rabbitmq.send.queue}")
    private String queue;

    @Autowired
    private AmqpTemplate template;

    @Override
    public void send(String message) {
        logger.info("Send MQ message: " + message);
        template.convertAndSend(queue,message);
    }
}
