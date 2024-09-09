package api.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import domain.Candidate;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CandidateResponse(String id, Optional<String> photo, String fullName, String email,
                                Optional<String> phone, Optional<String> jobTitle) {

    public static CandidateResponse fromDomain(Candidate candidate) {
        return new CandidateResponse(candidate.id(),
                candidate.photo(),
                candidate.givenName() + " " + candidate.familyName(),
                candidate.email(),
                candidate.phone(),
                candidate.jobTitle());
    }
}
