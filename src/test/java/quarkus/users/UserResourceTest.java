package quarkus.users;

import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testUsersEndpoint() {
        given()
          .when().get("/api/users")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

}