package dev.struchkov.example.quarkus.kafka;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class EntityRepositoryImpl {

    private final Mutiny.SessionFactory factory;

    public Uni<EntityForDb> save(EntityForDb entityForDb) {
        return factory.withTransaction(
                session -> session.merge(entityForDb)
        );
    }

}
