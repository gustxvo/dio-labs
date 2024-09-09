package infrastructure.resource;

import api.CandidateApi;
import api.dto.input.CreateCandidate;
import api.dto.input.UpdateCandidate;
import api.dto.output.CandidateResponse;
import domain.Candidate;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/candidates")
public class CandidateResource {

    private final CandidateApi candidateApi;

    public CandidateResource(CandidateApi candidateApi) {
        this.candidateApi = candidateApi;
    }

    @GET
    public List<CandidateResponse> list() {
        return candidateApi.list();
    }

    @POST
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    public void create(CreateCandidate request) {
        candidateApi.create(request);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public CandidateResponse update(@PathParam("id") String id, UpdateCandidate request) {
        return candidateApi.update(id, request);
    }

}
