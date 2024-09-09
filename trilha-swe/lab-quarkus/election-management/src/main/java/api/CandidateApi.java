package api;

import api.dto.input.CreateCandidate;
import api.dto.input.UpdateCandidate;
import api.dto.output.CandidateResponse;
import domain.candidate.Candidate;
import domain.candidate.CandidateService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

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
