package api;

import api.dto.output.ElectionResponse;
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

    public List<ElectionResponse> findAll() {
        return electionService.findAll().stream()
                .map(ElectionResponse::fromDomain)
                .toList();
    }

}
