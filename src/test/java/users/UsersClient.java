package users;

import create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(CreateUserRequestBody body) {
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer b2ec65fbe6a01c4fdd06094347e0fc47815f17e078af6459aea9cc9e0c511d1b")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v2/users");
    }

    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v2/users");
    }
}
