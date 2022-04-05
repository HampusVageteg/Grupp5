package com.grupp5.grupp5sakila.entity;

import org.hibernate.Hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
//@AttributeOverride( name = "actor_Id", column = @Column(name = "actor_Id")) Ska denna vara här?
public class FilmActorId implements Serializable {
    private static final long serialVersionUID = -6384042383970362807L;
    @Column(name = "actor_id", nullable = false)
    private Integer actor_Id;
    @Column(name = "film_id", nullable = false)
    private Integer film_Id;

    public Integer getFilm_Id() {
        return film_Id;
    }

    public void setFilm_Id(Integer filmId) {
        this.film_Id = filmId;
    }

    public Integer getActor_Id() {
        return actor_Id;
    }

    public void setActor_Id(Integer actorId) {
        this.actor_Id = actorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor_Id, film_Id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmActorId entity = (FilmActorId) o;
        return Objects.equals(this.actor_Id, entity.actor_Id) &&
                Objects.equals(this.film_Id, entity.film_Id);
    }
}