package com.grupp5.grupp5sakila.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "film_actor", indexes = {
        @Index(name = "idx_fk_film_id", columnList = "film_id")
})
public class FilmActor {
    @EmbeddedId
    private FilmActorId actor_Id;

    @MapsId("actor_Id")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @MapsId("film_Id")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public FilmActor(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }

    public FilmActor(){

    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public FilmActorId getActor_Id() {
        return actor_Id;
    }

    public void setActor_Id(FilmActorId id) {
        this.actor_Id = id;
    }
}