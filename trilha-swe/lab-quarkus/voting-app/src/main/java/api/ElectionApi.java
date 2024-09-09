package api;

import api.output.ElectionResponse;
import domain.ElectionService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ElectionApi {

    private final ElectionService electionService;

    public ElectionApi(ElectionService electionService) {
        this.electionService = electionService;
    }

    public List<ElectionResponse> findAll() {
        return electionService.findAll().stream()
                .map(ElectionResponse::fromDomain)
                .toList();
    }

    public void vote(String electionId, String candidateId) {
        electionService.vote(electionId, candidateId);
    }
}
