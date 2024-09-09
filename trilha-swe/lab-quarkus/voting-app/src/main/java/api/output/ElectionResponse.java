package api.output;

import domain.Candidate;
import domain.Election;

import java.util.List;

public record ElectionResponse(String id, List<String> candidates) {

    public static ElectionResponse fromDomain(Election election) {
        return new ElectionResponse(election.id(), election.candidates().stream().map(Candidate::id).toList());
    }
}
