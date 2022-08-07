package dev.struchkov.example.quarkus.kafka;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "entity_for_db")
public class EntityForDb extends PanacheEntity {

    @Column(name = "count")
    private Integer count;

}
