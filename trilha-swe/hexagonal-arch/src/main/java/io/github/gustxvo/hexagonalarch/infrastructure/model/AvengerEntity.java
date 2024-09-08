package io.github.gustxvo.hexagonalarch.infrastructure.model;

import io.github.gustxvo.hexagonalarch.domain.model.Avenger;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "avengers")
public class AvengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "avenger_id")
    private Long id;

    private String nick;
    private String person;
    private String description;
    private String history;

    public AvengerEntity(Avenger avenger) {
        this.id = avenger.id();
        this.nick = avenger.nick();
        this.person = avenger.person();
        this.description = avenger.description();
        this.history = avenger.history();
    }

    public Avenger toModel() {
        return new Avenger(id, nick, person, description, history);
    }

}
