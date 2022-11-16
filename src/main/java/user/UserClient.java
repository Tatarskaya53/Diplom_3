package user;

import config.Config;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserClient {

    private final String ROOT = "/api/auth";
    private final String LOGIN = ROOT + "/login";
    private final String REGISTER = ROOT + "/register";
    private final String USER = ROOT + "/user";
    String token;

    public Response createUniqueUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .baseUri(Config.BASE_URL)
                .post(REGISTER);
    }
    public Response deleteUser(User user, UserCredentials credentials) {
        token = given()
                .header("Content-Type", "application/json")
                .baseUri(Config.BASE_URL)
                .body(credentials)
                .when()
                .post(LOGIN)
                .then()
                .extract().path("accessToken");

        return given()
                .header("Content-Type", "application/json")
                .header("Authorization",token)
                .baseUri(Config.BASE_URL)
                .body(user)
                .when()
                .delete(USER);
    }
}
