package net.tecgurus.voting.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Concepts {
    @Id
    @SequenceGenerator(sequenceName = "SEQ_CONCEPTS", name = "seq_conc", allocationSize = 1)
    @GeneratedValue(generator = "seq_conc", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CONCEPT")
    private Integer idConcept;
    @Basic
    @Column(name = "NAME_CONCEPT")
    private String nameConcept;

}
