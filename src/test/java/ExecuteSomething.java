import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ExecuteSomething {
    @Test
    public void getAllUSers(){
        //Arrange
        //Act
        //Assert

        given()
                .when()
                    .get("https://gorest.co.in/public/v2/users")
                .then()
                    .statusCode(200)
                    .log().body();
    }

    @Test
    public void createANewUSer(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer b2ec65fbe6a01c4fdd06094347e0fc47815f17e078af6459aea9cc9e0c511d1b")
                .body("{\n" +
                        "  \"name\": \"Tenali Ramakrishna\",\n" +
                        "  \"gender\": \"male\",\n" +
                        "  \"email\": \"tenali.ramakrishna3@gmail.com\",\n" +
                        "  \"status\": \"active\"\n" +
                        "}")
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                .then()
                .log().body()
                .statusCode(201);
    }
}
