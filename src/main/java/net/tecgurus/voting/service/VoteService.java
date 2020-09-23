package net.tecgurus.voting.service;

import net.tecgurus.voting.dto.VoteDTO;
import net.tecgurus.voting.persistence.ConceptsRepository;
import net.tecgurus.voting.persistence.VotesRepository;
import net.tecgurus.voting.persistence.entities.Concepts;
import net.tecgurus.voting.persistence.entities.Votes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VotesRepository votesRepository;
    @Autowired
    private ConceptsRepository conceptsRepository;

    public void registerConcept(String concept){
        Concepts c = new Concepts();
        c.setNameConcept(concept);
        c = conceptsRepository.save(c);
        Votes v = new Votes();
        v.setIdConcept(c.getIdConcept());
        v.setVotes(1);
        votesRepository.save(v);
    }

    public void vote(Integer idConcept){
        Optional<Votes> optionalVotes = votesRepository.findById(idConcept);
        if(optionalVotes.isPresent()){
            Votes v = optionalVotes.get();
            v.setVotes(v.getVotes() + 1);
            votesRepository.save(v);
        }
    }

    public List<VoteDTO> getData() {
        List<VoteDTO> list = new ArrayList<>();
        List<Concepts> conceptsList = conceptsRepository.findAll();
        if (conceptsList != null && !conceptsList.isEmpty()) {
            for (Concepts c : conceptsList) {
                Optional<Votes> votesOptional = votesRepository.findById(c.getIdConcept());
                if (votesOptional.isPresent()) {
                    Votes v = votesOptional.get();
                    VoteDTO dto = VoteDTO.builder()
                            .id(v.getIdConcept())
                            .name(c.getNameConcept())
                            .votes(v.getVotes())
                            .build();
                    list.add(dto);
                }
            }
        }
        return list;
    }

}
