package quarkus.tv;

import org.jboss.resteasy.reactive.NoCache;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/tv")
public class TvShowResource
{
    @Inject
    SecurityIdentity iam;

    @GET
    @Path("/")
    @RolesAllowed("user")
    @NoCache
    public Response getTv()
    {
        return Response.ok().build();
    }
}
