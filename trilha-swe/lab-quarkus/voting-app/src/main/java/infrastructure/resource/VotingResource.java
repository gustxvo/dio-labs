package infrastructure.resource;

import api.ElectionApi;
import api.output.ElectionResponse;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/voting")
public class VotingResource {

    private final ElectionApi electionApi;

    public VotingResource(ElectionApi electionApi) {
        this.electionApi = electionApi;
    }

    @GET
    public List<ElectionResponse> elections() {
        return electionApi.findAll();
    }

    @POST
    @Path("/elections/{electionId}/candidates/{candidateId}")
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    private void vote(@PathParam("electionId") String electionId, @PathParam("candidateId") String candidateId) {
        electionApi.vote(electionId, candidateId);
    }

}
