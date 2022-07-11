import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

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
                    .log().body()
                    .body("[0].gender",Matchers.equalTo("female"))
                    .body(".",Matchers.hasItem(Matchers.hasEntry("gender","female")));
//                    .body(is(10))
//                    .assertThat().body(Matchers.hasSize(10));
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
                        "  \"email\": \"tenali.ramakrishna5@gmail.com\",\n" +
                        "  \"status\": \"active\"\n" +
                        "}")
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                .then()
                    .log().body()
                    .statusCode(201)

                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna5@gmail.com"));

    }
}
