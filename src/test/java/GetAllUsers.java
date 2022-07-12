import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class GetAllUsers {
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


}
