package net.tecgurus.voting.persistence;

import net.tecgurus.voting.persistence.entities.Concepts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceptsRepository extends JpaRepository<Concepts, Integer> {
}
