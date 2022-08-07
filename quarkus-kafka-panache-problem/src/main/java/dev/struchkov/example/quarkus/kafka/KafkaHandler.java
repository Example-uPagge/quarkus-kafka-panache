package dev.struchkov.example.quarkus.kafka;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class KafkaHandler {

    private final PanacheRepositoryImpl panacheRepository;

    @Incoming("test")
    public Uni<Void> handle(KafkaMessage message) {
        System.out.println("Получено сообщение " + message);
        final EntityForDb entityForDb = new EntityForDb();
        entityForDb.setCount(message.getCount());
        return panacheRepository.persistAndFlush(entityForDb).replaceWithVoid();
    }

}
