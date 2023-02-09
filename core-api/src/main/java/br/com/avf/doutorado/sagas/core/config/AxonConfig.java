package br.com.avf.doutorado.sagas.core.config;

import com.mongodb.client.MongoClient;
import com.thoughtworks.xstream.XStream;
import org.axonframework.config.Configurer;
import org.axonframework.config.ConfigurerModule;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.extensions.mongo.DefaultMongoTemplate;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {

    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();

        xStream.allowTypesByWildcard(new String[]{
                "br.com.**",
                "java.**",
                "org.axonframework",
        });
        return xStream;
    }

    @Bean
    public ConfigurerModule processorDefaultConfigurerModule() {
        return configurer -> configurer.eventProcessing(EventProcessingConfigurer::usingTrackingEventProcessors);
    }

    @Bean
    @Primary
    public Serializer serializer() {
        return JacksonSerializer.defaultSerializer();
    }

    @Bean

    public EmbeddedEventStore eventStore(EventStorageEngine storageEngine) {

        Configurer configurer = DefaultConfigurer.defaultConfiguration();
        return EmbeddedEventStore.builder()
                .storageEngine(storageEngine)
                .messageMonitor(configurer.buildConfiguration().messageMonitor(EventStore.class,
                        "eventStore"))
                .build();

    }

    @Bean

    public EventStorageEngine storageEngine(MongoClient client) {

        return MongoEventStorageEngine.builder()
                .mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build())

                .eventSerializer(JacksonSerializer.defaultSerializer())

                .snapshotSerializer(JacksonSerializer.defaultSerializer())

                .build();
    }
}
