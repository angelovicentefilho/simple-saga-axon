package br.com.avf.doutorado.sagas.order;

import br.com.avf.doutorado.sagas.core.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class OrderSagasApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSagasApplication.class, args);
    }

}
