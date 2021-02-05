package com.sbrf.depo.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HTTPSender implements Sender<String> {

    Logger logger = LoggerFactory.getLogger(HTTPSender.class);

    @Value("${http.uri}")
    private String uri;

    private final RestTemplate restTemplate = (new RestTemplateBuilder().build());

    @Override
    public void send(String message) {
        logger.info("Send HTTP post message: " + message);

        this.restTemplate.postForLocation(this.uri, message);
                //getForObject(this.uri, String.class);
    }

}
