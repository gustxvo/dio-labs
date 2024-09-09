package infrastructure.repository;

import domain.election.Election;
import domain.election.ElectionRepository;
import infrastructure.entity.ElectionCandidateEntity;
import infrastructure.entity.ElectionEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SqlElectionRepository implements ElectionRepository {

    private final EntityManager entityManager;

    public SqlElectionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void submit(Election election) {
        entityManager.merge(ElectionEntity.fromDomain(election));

        election.votes()
                .entrySet()
                .stream()
                .map(entry -> ElectionCandidateEntity.fromDomain(election, entry.getKey(), entry.getValue()))
                .forEach(entityManager::merge);
    }

}
