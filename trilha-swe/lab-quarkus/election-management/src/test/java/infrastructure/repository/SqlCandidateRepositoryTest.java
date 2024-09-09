package infrastructure.repository;

import domain.candidate.CandidateRepository;
import domain.CandidateRepositoryTest;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;

@QuarkusTest
class SqlCandidateRepositoryTest extends CandidateRepositoryTest {

    @Inject
    SqlCandidateRepository candidateRepository;

    @Inject
    EntityManager entityManager;

    @Override
    public CandidateRepository candidateRepository() {
        return candidateRepository;
    }

    @AfterEach
    @TestTransaction
    void tearDown() {
        entityManager.createNativeQuery("TRUNCATE TABLE candidates").executeUpdate();
    }

}