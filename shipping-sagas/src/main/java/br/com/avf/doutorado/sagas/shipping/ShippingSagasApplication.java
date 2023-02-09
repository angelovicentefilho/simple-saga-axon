package br.com.avf.doutorado.sagas.shipping;

import br.com.avf.doutorado.sagas.core.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class ShippingSagasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingSagasApplication.class, args);
    }

}
