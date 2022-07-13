import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class GetAllUsers {

    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void getAllUSers(){
        //Act
        usersClient.getAllUsers()
                .then()
        //Assert
                    .statusCode(200)
                    .log().body()
                    .body("[0].gender",Matchers.equalTo("female"))
                    .body(".",Matchers.hasItem(Matchers.hasEntry("gender","female")));
//                    .body(is(10))
//                    .assertThat().body(Matchers.hasSize(10));
    }
}
