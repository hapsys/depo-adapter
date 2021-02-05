package com.sbrf.depo.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPReceiver implements Receiver<String> {

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 200;

    private static final Logger logger = LoggerFactory.getLogger(HTTPReceiver.class);

    @Autowired
    private MQSender callbackSender;


    @Override
    @RequestMapping("${http.endpoint}")
    public ResponseEntity receive(@RequestBody String message) {
        logger.info("Received from HTTP: " + message);
        this.callbackSender.send(message);
        return ResponseEntity.status(CODE_SUCCESS).body(SUCCESS_STATUS);
    }

}
