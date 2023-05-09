package com.example.demo;

import com.azure.spring.messaging.checkpoint.Checkpointer;
import com.azure.spring.messaging.eventhubs.support.EventHubsHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import java.util.function.Consumer;
import java.util.function.Supplier;
import static com.azure.spring.messaging.AzureHeaders.CHECKPOINTER;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    private static final Sinks.Many<Message<String>> many = Sinks.many().unicast().onBackpressureBuffer();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public Supplier<Flux<Message<String>>> supply() {
        return ()->many.asFlux()
                .doOnNext(m->LOGGER.info("Manually sending message {}", m))
                .doOnError(t->LOGGER.error("Error encountered", t));
    }

    /*@Bean
    public Consumer<Message<String>> consume() {
        return message -> {

            Checkpointer checkpointer = (Checkpointer) message.getHeaders().get(CHECKPOINTER);
            LOGGER.info("New message received: '{}', partition key: {}, sequence number: {}, offset: {}, enqueued "
                            + "time: {}",
                    message.getPayload(),
                    message.getHeaders().get(EventHubsHeaders.PARTITION_KEY),
                    message.getHeaders().get(EventHubsHeaders.SEQUENCE_NUMBER),
                    message.getHeaders().get(EventHubsHeaders.OFFSET),
                    message.getHeaders().get(EventHubsHeaders.ENQUEUED_TIME)
            );
            if (checkpointer != null) {
                checkpointer.success()
                        .doOnSuccess(success -> LOGGER.info("Message '{}' successfully checkpointed",
                                message.getPayload()))
                        .doOnError(error -> LOGGER.error("Exception found", error))
                        .block();
            } else {
                LOGGER.warn("Checkpointer is null. Unable to checkpoint the message.");
            }
        };
    }*/

    @Bean
    public Consumer<Message<String>> consume() {
        return message->LOGGER.info("New message received: '{}'", message.getPayload());
    }


    /*@Override
    public void run(String... args) {
        LOGGER.info("Going to add message {} to sendMessage.", "Hello Word");
        many.emitNext(MessageBuilder.withPayload("Hello Word").build(), Sinks.EmitFailureHandler.FAIL_FAST);
    }*/
    @Override
    public void run(String... args) {
        many.emitNext(new GenericMessage<>("Hello Word"), Sinks.EmitFailureHandler.FAIL_FAST);
    }

}

