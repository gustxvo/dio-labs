package domain.election;

import domain.annotation.Principal;
import domain.candidate.CandidateService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;

import java.util.List;

@ApplicationScoped
public class ElectionService {

    private final CandidateService candidateService;
    private final Instance<ElectionRepository> repositories;
    private final ElectionRepository electionRepository;

    public ElectionService(CandidateService candidateService, @Any Instance<ElectionRepository> repositories,
                           @Principal ElectionRepository electionRepository) {
        this.candidateService = candidateService;
        this.repositories = repositories;
        this.electionRepository = electionRepository;
    }

    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    public void submit() {
        Election election = Election.create(candidateService.findAll());
        repositories.forEach(repository -> repository.submit(election));
    }
}
