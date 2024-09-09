package api;

import api.dto.input.CreateCandidate;
import api.dto.input.UpdateCandidate;
import api.dto.output.CandidateResponse;
import domain.Candidate;
import domain.CandidateService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@QuarkusTest
class CandidateApiTest {

    @Inject
    CandidateApi candidateApi;

    @InjectMock
    CandidateService candidateService;

    @Test
    void list() {
        List<Candidate> candidates = Instancio.stream(Candidate.class).limit(10).toList();

        when(candidateService.findAll()).thenReturn(candidates);

        List<CandidateResponse> response = candidateApi.list();

        verify(candidateService).findAll();
        verifyNoMoreInteractions(candidateService);

        assertEquals(candidates.stream().map(CandidateResponse::fromDomain).toList(), response);
    }

    @Test
    void create() {
        CreateCandidate request = Instancio.create(CreateCandidate.class);
        ArgumentCaptor<Candidate> captor = ArgumentCaptor.forClass(Candidate.class);

        candidateApi.create(request);

        verify(candidateService).save(captor.capture());
        verifyNoMoreInteractions(candidateService);

        Candidate candidate = captor.getValue();
        assertEquals(request.photo(), candidate.photo());
        assertEquals(request.givenName(), candidate.givenName());
        assertEquals(request.familyName(), candidate.familyName());
        assertEquals(request.email(), candidate.email());
        assertEquals(request.phone(), candidate.phone());
        assertEquals(request.jobTitle(), candidate.jobTitle());
    }

    @Test
    void update() {
        String id = UUID.randomUUID().toString();
        UpdateCandidate candidateDto = Instancio.create(UpdateCandidate.class);
        Candidate candidate = candidateDto.toDomain(id);
        ArgumentCaptor<Candidate> captor = ArgumentCaptor.forClass(Candidate.class);

        when(candidateService.findById(id)).thenReturn(candidate);

        CandidateResponse response = candidateApi.update(id, candidateDto);
        verify(candidateService).save(captor.capture());
        verify(candidateService).findById(id);
        verifyNoMoreInteractions(candidateService);
        assertEquals(CandidateResponse.fromDomain(candidate), response);
    }

}