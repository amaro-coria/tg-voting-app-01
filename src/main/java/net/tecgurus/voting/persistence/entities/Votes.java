package net.tecgurus.voting.persistence.entities;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Votes {
    @Id
    @Column(name = "ID_CONCEPT")
    private Integer idConcept;
    @Basic
    @Column(name = "VOTES")
    private Integer votes;

}
