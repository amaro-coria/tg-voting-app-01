package net.tecgurus.voting.persistence;

import net.tecgurus.voting.persistence.entities.Votes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<Votes, Integer> {
}
