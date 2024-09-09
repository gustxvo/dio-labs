package infrastructure.entity;

import domain.election.Election;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "elections")
public class ElectionEntity {

    @Id
    private String id;

    public ElectionEntity() {
    }

    public ElectionEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ElectionEntity fromDomain(Election election) {
        return new ElectionEntity(election.id());
    }
}
