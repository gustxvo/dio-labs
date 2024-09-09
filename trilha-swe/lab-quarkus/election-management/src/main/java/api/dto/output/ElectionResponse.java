package api.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import domain.candidate.Candidate;
import domain.election.Election;

import java.util.List;
import java.util.Optional;

public record ElectionResponse(String id, List<CandidateResponse> candidates) {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public record CandidateResponse(String id, Optional<String> photo, String fullName, String email,
                                    Optional<String> phone, Optional<String> jobTitle, Integer votes) {
    }

    public static ElectionResponse fromDomain(Election election) {
        List<CandidateResponse> candidates = election.votes()
                .entrySet().stream()
                .map(entry -> {
                    Candidate candidate = entry.getKey();
                    return new CandidateResponse(candidate.id(),
                            candidate.photo(),
                            candidate.givenName() + " " + candidate.familyName(),
                            candidate.email(),
                            candidate.phone(),
                            candidate.jobTitle(),
                            entry.getValue());
                }).toList();

        return new ElectionResponse(election.id(), candidates);
    }
}
