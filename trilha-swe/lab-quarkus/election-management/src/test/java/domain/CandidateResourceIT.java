package domain;

import api.dto.input.CreateCandidate;
import api.dto.input.UpdateCandidate;
import api.dto.output.CandidateResponse;
import infrastructure.resource.CandidateResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.MediaType;
import org.instancio.Instancio;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@QuarkusIntegrationTest
@TestHTTPEndpoint(CandidateResource.class)
public class CandidateResourceIT {

    @Test
    void create() {
        CreateCandidate request = Instancio.create(CreateCandidate.class);

        given().contentType(MediaType.APPLICATION_JSON).body(request)
                .when().post()
                .then().statusCode(RestResponse.StatusCode.CREATED);
    }

    @Test
    void update() {
        var id = UUID.randomUUID().toString();
        var request = Instancio.create(UpdateCandidate.class);

        var update = Instancio.of(UpdateCandidate.class)
                .set(field("photo"), request.photo())
                .set(field("givenName"), "Thiago")
                .set(field("familyName"), "Poiani")
                .set(field("email"), request.email())
                .set(field("phone"), request.phone())
                .set(field("jobTitle"), request.jobTitle())
                .create();

        var response1 = given().contentType(MediaType.APPLICATION_JSON).body(request)
                .when().put("/" + id)
                .then().statusCode(RestResponse.StatusCode.OK).extract().as(CandidateResponse.class);

        var response2 = given().contentType(MediaType.APPLICATION_JSON).body(update)
                .when().put("/" + id)
                .then().statusCode(RestResponse.StatusCode.OK).extract().as(CandidateResponse.class);

        assertEquals(response1.id(), id);
        assertEquals(response2.id(), id);
        assertNotEquals(response1.fullName(), response2.fullName());
        assertEquals(response1.email(), response2.email());
        assertEquals(response1.phone(), response2.phone());
        assertEquals(response1.jobTitle(), response2.jobTitle());
    }
}
