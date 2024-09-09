package infrastructure.resource;

import api.CandidateApi;
import api.dto.input.CreateCandidate;
import api.dto.input.UpdateCandidate;
import api.dto.output.CandidateResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.instancio.Instancio;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@QuarkusTest
@TestHTTPEndpoint(CandidateResource.class)
class CandidateResourceTest {

    @InjectMock
    CandidateApi candidateApi;

    @Test
    void create() {
        CreateCandidate request = Instancio.create(CreateCandidate.class);

        given().contentType(MediaType.APPLICATION_JSON).body(request)
                .when().post()
                .then().statusCode(RestResponse.StatusCode.CREATED);

        verify(candidateApi).create(request);
        verifyNoMoreInteractions(candidateApi);
    }

    @Test
    void list() {
        List<CandidateResponse> candidates = Instancio.stream(CandidateResponse.class).limit(4).toList();

        when(candidateApi.list()).thenReturn(candidates);

        var response = given()
                .when().get()
                .then().statusCode(RestResponse.StatusCode.OK).extract().as(CandidateResponse[].class);

        verify(candidateApi).list();
        verifyNoMoreInteractions(candidateApi);

        assertEquals(candidates, Arrays.stream(response).toList());
    }

    @Test
    void update() {
        UpdateCandidate request = Instancio.create(UpdateCandidate.class);
        CandidateResponse candidate = Instancio.create(CandidateResponse.class);

        when(candidateApi.update(candidate.id(), request)).thenReturn(candidate);

        var response = given().contentType(MediaType.APPLICATION_JSON).body(request)
                .when().put("/" + candidate.id())
                .then().statusCode(RestResponse.StatusCode.OK).extract().as(CandidateResponse.class);

        verify(candidateApi).update(candidate.id(), request);
        verifyNoMoreInteractions(candidateApi);

        assertEquals(candidate, response);
    }
}