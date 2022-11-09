package dev.struchkov.example.quarkus.generator;


import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.reactive.messaging.MutinyEmitter;
import org.eclipse.microprofile.reactive.messaging.Channel;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@Startup
@ApplicationScoped
public class KafkaMessageGenerator {

    private final MutinyEmitter<KafkaMessage> telegramChannel;

    public KafkaMessageGenerator(@Channel("test") MutinyEmitter<KafkaMessage> telegramChannel) {
        this.telegramChannel = telegramChannel;
    }

    public void start(@Observes StartupEvent ev) {
        for (int i = 0; i < 50; i++) {
            final KafkaMessage kafkaMessage = new KafkaMessage();
            kafkaMessage.setCount(i);
            telegramChannel.sendAndAwait(kafkaMessage);
            System.out.println("Отправлено сообщение: " + kafkaMessage);
        }
    }

}
