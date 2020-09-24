package net.tecgurus.voting.controller;

import lombok.extern.slf4j.Slf4j;
import net.tecgurus.voting.dto.ConceptRequest;
import net.tecgurus.voting.dto.VoteDTO;
import net.tecgurus.voting.dto.VoteRequest;
import net.tecgurus.voting.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/vote")
@CrossOrigin(value = "*")
@Slf4j
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping
    public ResponseEntity<List<VoteDTO>> findData(){
        log.info("Se estan pidiendo datos en la aplicacion");
        List<VoteDTO> voteDTOS = voteService.getData();
        if(voteDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voteDTOS);
    }

    @PostMapping(value = "/vote")
    public ResponseEntity<VoteRequest> vote(@RequestBody VoteRequest request){
        voteService.vote(request.getIdConcept());
        return ResponseEntity.ok(request);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<ConceptRequest> register(@RequestBody ConceptRequest request){
        voteService.registerConcept(request.getConceptName());
        return ResponseEntity.ok(request);
    }


}
