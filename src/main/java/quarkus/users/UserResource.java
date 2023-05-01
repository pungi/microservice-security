package quarkus.users;

import org.jboss.resteasy.reactive.NoCache;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/users")
public class UserResource
{

    @Inject
    SecurityIdentity iam;

    @GET
    @Path("/me")
    @RolesAllowed("user")
    @NoCache
    public User me()
    {
        return new User(iam);
    }

    public static class User
    {

        private final String userName;

        User(SecurityIdentity iam)
        {
            this.userName = iam.getPrincipal().getName();
        }

        public String getUserName()
        {
            return userName;
        }
    }
}