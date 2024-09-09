package infrastructure.resource;

import api.ElectionApi;
import api.dto.output.ElectionResponse;
import domain.election.Election;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/elections")
public class ElectionResource {

    private final ElectionApi electionApi;

    public ElectionResource(ElectionApi electionApi) {
        this.electionApi = electionApi;
    }

    @POST
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    public void create() {
        electionApi.submit();
    }

    @GET
    public List<ElectionResponse> list() {
        return electionApi.findAll();
    }
}
