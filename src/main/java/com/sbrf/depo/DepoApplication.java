package com.sbrf.depo;

import com.sbrf.depo.rabbitmq.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@Import(RabbitConfiguration.class)
public class DepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepoApplication.class, args);
    }

}
