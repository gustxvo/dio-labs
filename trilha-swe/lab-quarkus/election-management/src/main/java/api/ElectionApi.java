package api;

import api.dto.input.CreateCandidate;
import api.dto.input.UpdateCandidate;
import api.dto.output.CandidateResponse;
import domain.candidate.Candidate;
import domain.candidate.CandidateService;
import domain.election.ElectionService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ElectionApi {

    private final ElectionService electionService;


    public ElectionApi(ElectionService electionService) {
        this.electionService = electionService;
    }

    public void submit() {
        electionService.submit();
    }

}
