package users;

import create.CreateUserRequestBody;
import create.response.CreateUserErrorResponse;
import create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return
                createUserResponse;
    }

    public CreateUserErrorResponse[] createUserExpectingError(CreateUserRequestBody body) {

        Response negativeResponse = create(body);
        CreateUserErrorResponse[] createUserErrorResponse = negativeResponse.as(CreateUserErrorResponse[].class);

//        List<Field> all = negativeResponse.getBody().as(new TypeRef<List<Field>>() {
//        });
//
//        System.out.println(all);

//        Arrays.stream(createUserErrorResponse).filter(f->f.setStatusCode(negativeResponse.statusCode())).collect(Collectors.toList());

        for (CreateUserErrorResponse  resp:createUserErrorResponse) {
            resp.setStatusCode(negativeResponse.statusCode());
        }

//        createUserErrorResponse.setStatusCode(negativeResponse.statusCode());

//        return createUserErrorResponse;
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

    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v2/users");
    }
}
