package br.com.avf.doutorado.sagas.payment;

import br.com.avf.doutorado.sagas.core.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class PaymentSagasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentSagasApplication.class, args);
    }

}
