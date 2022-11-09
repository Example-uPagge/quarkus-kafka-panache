package dev.struchkov.example.quarkus.kafka;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;

@ApplicationScoped
@RequiredArgsConstructor
public class KafkaHandlerForOldVersion {

    private final EntityRepositoryImpl panacheRepository;

    @Incoming("test")
    @ActivateRequestContext
    public Uni<Void> handle(KafkaMessage message) {
        System.out.println("Получено сообщение " + message);
        final EntityForDb entityForDb = new EntityForDb();
        entityForDb.setCount(message.getCount());
        return panacheRepository.save(entityForDb).replaceWithVoid();
    }

}
