package users;

import create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public Response create(CreateUserRequestBody body) {
        Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer b2ec65fbe6a01c4fdd06094347e0fc47815f17e078af6459aea9cc9e0c511d1b")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v2/users");

        response.then().log().body();

        return response;
    }

    public Response getAll() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response
                .then().log().body();
        return response;
    }

    public Response get(int id) {
        Response response = given()
                .pathParam("id", id)
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}");

        response.then().log().body();
        return response;
    }

    public Response delete(int id){
        Response response =
          given()
                .pathParam("id", id)
                .header("Authorization", "Bearer b2ec65fbe6a01c4fdd06094347e0fc47815f17e078af6459aea9cc9e0c511d1b")
          .when()
                .delete("https://gorest.co.in/public/v2/users/{id}");

        response.then()
                .log().body();

        return  response;
    }

    public Response updateUser(CreateUserRequestBody createUserRequestBody,int id){
        Response response =
                given()
                    .pathParam("id", id)
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer b2ec65fbe6a01c4fdd06094347e0fc47815f17e078af6459aea9cc9e0c511d1b")
                    .body(createUserRequestBody)
                .when()
                     .patch("https://gorest.co.in/public/v2/users/{id}");

        response
                .then().log().body();

        return response;
    }
}
