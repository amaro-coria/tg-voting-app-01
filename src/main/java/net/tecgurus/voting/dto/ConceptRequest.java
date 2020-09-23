package net.tecgurus.voting.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConceptRequest implements Serializable {

    private String conceptName;

}
