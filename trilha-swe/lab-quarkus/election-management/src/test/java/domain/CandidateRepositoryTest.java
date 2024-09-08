package domain;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;

public abstract class CandidateRepositoryTest {

    public abstract CandidateRepository candidateRepository();

    @Test
    void save() {
        Candidate candidate = Instancio.create(Candidate.class);
         candidateRepository().save(candidate);

        Optional<Candidate> result = candidateRepository().findById(candidate.id());
        assertTrue(result.isPresent());
        assertEquals(candidate, result.get());
    }

    @Test
    void findAll() {
        List<Candidate> candidates = Instancio.stream(Candidate.class).limit(10).toList();
        candidateRepository().save(candidates);

        List<Candidate> result = candidateRepository().findAll();
        assertEquals(candidates.size(), result.size());
    }

    @Test
    void findByName() {
        Candidate candidate1 = Instancio.create(Candidate.class);
        Candidate candidate2 = Instancio.of(Candidate.class)
                .set(field("familyName"), "Dio")
                .create();

        CandidateQuery query = new CandidateQuery.Builder().name("Di").build();
        candidateRepository().save(candidate1);
        candidateRepository().save(candidate2);
        List<Candidate> result = candidateRepository().find(query);
        assertEquals(1, result.size());
        assertEquals(candidate2.familyName(), result.getFirst().familyName());
    }

}