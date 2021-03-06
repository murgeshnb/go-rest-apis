import create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUSers {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void createNewMaleUSer(){
        //Arrange
        String email= String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").email(email).gender("male").status("active").build();

        //Act
        usersClient.createUser(createUserRequestBody)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email))
                .body("name",Matchers.equalTo("Tenali Ramakrishna"));

    }

    @Test
    public void createNewFemaleUSer(){
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Raziya").gender("female").email(email).status("active").build();
        //Act
        usersClient.createUser(createUserRequestBody)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email))
                .body("name",Matchers.equalTo("Raziya"));
    }
}
