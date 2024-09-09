package api;

import api.dto.input.CreateCandidate;
import api.dto.input.UpdateCandidate;
import api.dto.output.CandidateResponse;
import domain.Candidate;
import domain.CandidateService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class CandidateApi {

    private final CandidateService candidateService;

    public CandidateApi(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    public List<CandidateResponse> list() {
        return candidateService.findAll().stream()
                .map(CandidateResponse::fromDomain)
                .toList();
    }

    public void create(CreateCandidate candidate) {
        candidateService.save(candidate.toDomain());
    }

    public CandidateResponse update(String id, UpdateCandidate request) {
        candidateService.save(request.toDomain(id));
        Candidate candidate = candidateService.findById(id);
        return CandidateResponse.fromDomain(candidate);
    }

}
