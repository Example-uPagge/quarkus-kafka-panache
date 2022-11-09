package dev.struchkov.example.quarkus.kafka;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepositoryImpl implements PanacheRepository<EntityForDb> {

}
