package infrastructure.repository;

import domain.candidate.Candidate;
import domain.candidate.CandidateQuery;
import domain.candidate.CandidateRepository;
import infrastructure.entity.CandidateEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class SqlCandidateRepository implements CandidateRepository {

    private final EntityManager entityManager;

    public SqlCandidateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(List<Candidate> candidates) {
        candidates.stream()
                .map(CandidateEntity::new)
                .forEach(entityManager::merge);
    }

    @Override
    public List<Candidate> find(CandidateQuery query) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CandidateEntity> criteriaQuery = criteriaBuilder.createQuery(CandidateEntity.class);
        Root<CandidateEntity> root = criteriaQuery.from(CandidateEntity.class);

        criteriaQuery.select(root).where(conditions(query, criteriaBuilder, root));

        return entityManager.createQuery(criteriaQuery)
                .getResultStream()
                .map(CandidateEntity::toDomain)
                .toList();
    }

    private Predicate[] conditions(CandidateQuery query, CriteriaBuilder cb, Root<CandidateEntity> root) {
        return Stream.of(query.ids().map(id -> cb.in(root.get("id")).value(id)),
                        query.name().map(name -> cb.or(cb.like(cb.lower(root.get("familyName")), name.toLowerCase() + "%"),
                                cb.like(cb.lower(root.get("givenName")), name.toLowerCase() + "%"))))
                .flatMap(Optional::stream)
                .toArray(Predicate[]::new);
    }
}
