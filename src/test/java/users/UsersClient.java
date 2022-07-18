package users;

import create.CreateUserRequestBody;
import create.response.CreateUserErrorResponse;
import create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.getAll.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());

        return createUserResponse;
    }

    public CreateUserErrorResponse[] createUserExpectingError(CreateUserRequestBody body) {

        Response negativeResponse = create(body);
        CreateUserErrorResponse[] createUserErrorResponse = negativeResponse.as(CreateUserErrorResponse[].class);

        for (CreateUserErrorResponse  resp:createUserErrorResponse) {
            resp.setStatusCode(negativeResponse.statusCode());
        }
        return createUserErrorResponse;
    }


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

    public GetAllUsersResponse getAllUsers() {

        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response
                .then().log().body();

        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(response.statusCode());

        return getAllUsersResponse;
    }
}
