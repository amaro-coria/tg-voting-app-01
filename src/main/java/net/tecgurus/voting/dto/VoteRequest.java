package net.tecgurus.voting.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VoteRequest implements Serializable {

    private Integer idConcept;

}
