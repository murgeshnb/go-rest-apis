import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUSers {

    @Test
    public void createNewMaleUSer(){
        //Arrange
        String body=" \"name\": \"Tenali Ramakrishna\",\n"+" \"gender\": \"male\",\n"+" \"email\": \"tenali.ramakrishna8@gmail.com\",\n";

        //Act
        createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna8@gmail.com"))
                .body("name",Matchers.equalTo("Tenali Ramakrishna"));

    }

    @Test
    public void createNewFemaleUSer(){
        //Arrange
        String body=" \"name\": \"Raziya\",\n"+" \"gender\": \"female\",\n"+ " \"email\": \"Raziya11@gmail.com\",\n";

        //Act
        createUser(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("Raziya11@gmail.com"))
                .body("name",Matchers.equalTo("Raziya"));

    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer b2ec65fbe6a01c4fdd06094347e0fc47815f17e078af6459aea9cc9e0c511d1b")
                .body("{\n" +
                        body+
                        "  \"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }


}
